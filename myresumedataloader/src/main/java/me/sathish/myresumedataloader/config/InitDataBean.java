package me.sathish.myresumedataloader.config;

import me.sathish.myresumedataloader.models.ResumeUserEducation;
import me.sathish.myresumedataloader.models.ResumeUserJob;
import me.sathish.myresumedataloader.models.ResumeUserProfile;
import me.sathish.myresumedataloader.repos.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitDataBean {
    final ResumeUserProfileRepo userProfileRepository;
    final UserRepository userRepository;
    final ResumeUserJobRepo resumeUserJobRepo;
    final ResumeUserEducationRepo resumeUserEducationRepo;

    public InitDataBean(ResumeUserProfileRepo userProfileRepository, UserRepository userRepository, ResumeUserJobRepo resumeUserJobRepo, ResumeUserEducationRepo resumeUserEducationRepo) {
        this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;
        this.resumeUserJobRepo = resumeUserJobRepo;
        this.resumeUserEducationRepo = resumeUserEducationRepo;
    }

    public String rootHello() {
        if (!userRepository.findByUserName("foo").isPresent()) {
            saveSecurityData();
            saveResumeProfile();
            List<ResumeUserProfile> resumeUserProfileList = saveResumeUserProfile();
            saveResumeUserEducation();
            resumeUserProfileList.forEach(data -> {
                List<ResumeUserJob> resumeUserJobs = new ArrayList<>();
                List<ResumeUserEducation> resumeUserEducationList = new ArrayList<>();
                data.setResumeUserJobList(resumeUserJobs);
                resumeUserJobs = resumeUserJobRepo.findAll();
                data.setResumeUserJobList(resumeUserJobs);
                resumeUserEducationList = resumeUserEducationRepo.findAll();
                ArrayList<String> skills = new ArrayList<>();
                skills.add("JAVA");
                skills.add("iOS");
                data.setResumeUserEducationList(resumeUserEducationList);
                data.setKeySkills(skills);
                userProfileRepository.save(data);
            });
        }
        return "created data";
    }

    private void saveResumeUserEducation() {
        ResumeUserEducation resumeUserEducation = new ResumeUserEducation();
        resumeUserEducation.setCollege("MIT");
        resumeUserEducation.setQualification("Bachelors Degree");
        resumeUserEducation.setSummary("This is the ultimate Degree");
        resumeUserEducation.setId(1);
        resumeUserEducation.setStartDate(LocalDate.of(2000, 6, 1));
        resumeUserEducation.setEndDate(LocalDate.of(2002, 10, 1));
        resumeUserEducationRepo.save(resumeUserEducation);
    }

    private List<ResumeUserProfile> saveResumeUserProfile() {
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
        resumeUserJobRepo.save(userJob);
        ResumeUserJob userJob2 = new ResumeUserJob();
        userJob2.setCompany("Novell Express");
        userJob2.setDesignation("Application Development Engineer");
        userJob2.setId(2);
        userJob2.setResponsibilities(myJobResp);
        userJob2.setStartDate(LocalDate.of(2000, 6, 1));
        userJob2.setEndDate(LocalDate.of(2002, 10, 1));
        List<ResumeUserProfile> resumeUserProfileList = userProfileRepository.findAll();
        resumeUserJobRepo.save(userJob2);
        return resumeUserProfileList;
    }

    private void saveResumeProfile() {
        ResumeUserProfile resumeUserProfile = new ResumeUserProfile();
        resumeUserProfile.setUserName("foo");
        resumeUserProfile.setTheme("1");
        resumeUserProfile.setSummary("Some Summary");
        resumeUserProfile.setName("Sathish Jayapal");
        resumeUserProfile.setPhone("60404023456");
        resumeUserProfile.setGitHubRepo("http://github.com");
        resumeUserProfile.setTwitterHandle("dotsky");
        userProfileRepository.save(resumeUserProfile);
    }

    private void saveSecurityData() {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUserName("foo");
        securityUser.setPassword("foo");
        securityUser.setActive(true);
        securityUser.setRoles("USER");
        userRepository.save(securityUser);
    }
}
