package me.sathish.resume.mynewresume.controllers;

import me.sathish.resume.mynewresume.exceptions.UserNotFoundException;
import me.sathish.resume.mynewresume.models.ResumeUserEducation;
import me.sathish.resume.mynewresume.models.ResumeUserJob;
import me.sathish.resume.mynewresume.models.ResumeUserProfile;
import me.sathish.resume.mynewresume.repos.ResumeUserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public String rootHello() {
        List<ResumeUserProfile> resumeUserProfileList = userProfileRepository.findAll();
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

            data.getResumeUserJobList().clear();
            data.getResumeUserJobList().add(userJob);
            data.getResumeUserJobList().add(userJob2);
            userProfileRepository.save(data);
            ResumeUserEducation resumeUserEducation = new ResumeUserEducation();
            resumeUserEducation.setCollege("MIT");
            resumeUserEducation.setQualification("Bachelors Degree");
            resumeUserEducation.setSummary("This is the ultimate Degree");
            resumeUserEducation.setId(1);
            resumeUserEducation.setStartDate(LocalDate.of(2000, 6, 1));
            resumeUserEducation.setEndDate(LocalDate.of(2002, 10, 1));
            data.getResumeUserEducationList().clear();
            data.getResumeUserEducationList().add(resumeUserEducation);
            userProfileRepository.save(data);

            data.getKeySkills().clear();
            data.getKeySkills().add("JAVA");
            data.getKeySkills().add("iOS");

            userProfileRepository.save(data);

        });
        userProfileRepository.findAll().stream().forEach(data -> System.out.println(data));
        return "hello";
    }

    @GetMapping("/edit")
    public String rootUser() {
        return "user";
    }

    @GetMapping("/view/{user}")
    public ResumeUserProfile viewUser(@PathVariable String user) {
        Optional<ResumeUserProfile> userProfileOptional = userProfileRepository.findByUserName(user);
        userProfileOptional.orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userProfileOptional.get().getUserName();
        return userProfileOptional.get();
    }
}
