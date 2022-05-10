package mynewresume.resume.controllers;

import mynewresume.resume.dto.ResumeUserProfileDto;
import mynewresume.resume.models.ResumeUserProfile;
import mynewresume.resume.repos.ResumeUserProfileRepo;
import mynewresume.security.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResumeController {
    private final ModelMapper modelMapper;
    private final ResumeUserProfileRepo userProfileRepository;

    public ResumeController(ModelMapper modelMapper,
                            ResumeUserProfileRepo userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String rootHello() {
        return "created data";
    }

    @GetMapping("/edit")
    public String rootUser() {
        return "user";
    }

    private ResumeUserProfileDto convertToDto(ResumeUserProfile resumeUserProfile) {
        ResumeUserProfileDto resumeUserProfileDto = modelMapper.map(resumeUserProfile, ResumeUserProfileDto.class);
        return resumeUserProfileDto;
    }

    @GetMapping("/view/{user}")
    @Transactional(readOnly = true)
    public ResumeUserProfileDto viewUser(@PathVariable String user) {
        List<ResumeUserProfile> userProfileOptional = userProfileRepository.findAll();
        if (userProfileOptional.size() < 0) throw new UserNotFoundException("User Not Found");
        ResumeUserProfile resumeUserProfile = userProfileOptional.stream().findFirst().get();
        ResumeUserProfileDto resumeUserProfileDto = convertToDto(resumeUserProfile);
        return resumeUserProfileDto;
    }
}
