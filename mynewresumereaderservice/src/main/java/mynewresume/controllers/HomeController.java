package mynewresume.controllers;

import mynewresume.dto.ResumeUserProfileDto;
import mynewresume.exceptions.UserNotFoundException;
import mynewresume.models.ResumeUserEducation;
import mynewresume.models.ResumeUserJob;
import mynewresume.models.ResumeUserProfile;
import mynewresume.models.SecurityUser;
import mynewresume.repos.ResumeUserProfileRepo;
import mynewresume.repos.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    ResumeUserProfileRepo userProfileRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String rootHello() {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUserName("foo");
        securityUser.setPassword("foo");
        securityUser.setActive(true);
        securityUser.setRoles("Active");
        userRepository.save(securityUser);
        ResumeUserProfile resumeUserProfile = new ResumeUserProfile();
        resumeUserProfile.setUserName("foo");
        resumeUserProfile.setTheme("1");
        resumeUserProfile.setSummary("Some Summary");
        resumeUserProfile.setName("Sathish Jayapal");
        resumeUserProfile.setPhone("60404023456");
        resumeUserProfile.setGitHubRepo("http://github.com");
        resumeUserProfile.setTwitterHandle("dotsky");
        userProfileRepository.save(resumeUserProfile);
        List<ResumeUserProfile> resumeUserProfileList = userProfileRepository.findAll();
        List<ResumeUserJob> resumeUserJobs = new ArrayList<>();
        List<ResumeUserEducation> resumeUserEducationList = new ArrayList<>();
        resumeUserProfileList.forEach(data -> {
            ArrayList<String> myJobResp = new ArrayList<>();
            myJobResp.add("First Job");
            myJobResp.add("Second Job");
            ResumeUserJob userJob = new ResumeUserJob();
            userJob.setCompany("American Express");
            userJob.setDesignation("Application Development Engineer");
            userJob.setId(1);
            userJob.setResponsibilities(myJobResp);
            userJob.setStartDate(LocalDate.of(1999, 5, 1));
            userJob.setEndDate(LocalDate.of(2000, 6, 1));
            ResumeUserJob userJob2 = new ResumeUserJob();
            userJob2.setCompany("Novell Express");
            userJob2.setDesignation("Application Development Engineer");
            userJob2.setId(2);
            userJob2.setResponsibilities(myJobResp);
            userJob2.setStartDate(LocalDate.of(2000, 6, 1));
            userJob2.setEndDate(LocalDate.of(2002, 10, 1));
            resumeUserJobs.add(userJob);
            resumeUserJobs.add(userJob2);
            ResumeUserEducation resumeUserEducation = new ResumeUserEducation();
            resumeUserEducation.setCollege("MIT");
            resumeUserEducation.setQualification("Bachelors Degree");
            resumeUserEducation.setSummary("This is the ultimate Degree");
            resumeUserEducation.setId(1);
            resumeUserEducation.setStartDate(LocalDate.of(2000, 6, 1));
            resumeUserEducation.setEndDate(LocalDate.of(2002, 10, 1));
            resumeUserEducationList.add(resumeUserEducation);
            data.setResumeUserEducationList(resumeUserEducationList);
            data.setResumeUserJobList(resumeUserJobs);
            data.setKeySkills(Arrays.asList("JAVA", "iOS"));
            userProfileRepository.save(data);
        });
        return "hello";
    }

    @GetMapping("/edit")
    public String rootUser() {
        return "user";
    }

    @Autowired
    private ModelMapper modelMapper;

    private ResumeUserProfileDto convertToDto(ResumeUserProfile resumeUserProfile) {
        ResumeUserProfileDto resumeUserProfileDto = modelMapper.map(resumeUserProfile, ResumeUserProfileDto.class);
        return resumeUserProfileDto;
    }

    @GetMapping("/view/{user}")
    @Transactional(readOnly = true)
    public ResumeUserProfileDto viewUser(@PathVariable String user) {
        Optional<ResumeUserProfile> userProfileOptional = userProfileRepository.findByUserName(user);
        userProfileOptional.orElseThrow(() -> new UserNotFoundException("User Not Found"));
        ResumeUserProfile resumeUserProfile = userProfileOptional.get();
        ResumeUserProfileDto resumeUserProfileDto = convertToDto(resumeUserProfile);
        return resumeUserProfileDto;
    }
}
