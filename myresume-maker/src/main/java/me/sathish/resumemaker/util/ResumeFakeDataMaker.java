package me.sathish.resumemaker.util;

import me.sathish.resumemaker.dto.ResumeUserEducationDto;
import me.sathish.resumemaker.dto.ResumeUserJobDto;
import me.sathish.resumemaker.dto.ResumeUserProfileDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ResumeFakeDataMaker {

    static ResumeUserProfileDto createSathishResume() {
        ResumeUserProfileDto resumeUserProfileDto = new ResumeUserProfileDto();
        resumeUserProfileDto.setId(2);
        resumeUserProfileDto.setName("Sathish Jayapal");
        resumeUserProfileDto.setEmail("sathishk.dot@gmail.com");
        resumeUserProfileDto.setGitHubRepo("https://github.com");
        resumeUserProfileDto.setPhone("6085665012");
        resumeUserProfileDto.setSummary("Some Summary");
        resumeUserProfileDto.setUserName("foo");
        resumeUserProfileDto.setTheme("1");

        List<String> keySkills = Arrays.asList("JAVA", "iOS");
        resumeUserProfileDto.setKeySkills(keySkills);

        List<String> summarySkillsList = Arrays.asList("Certified AWS and Azure Devops engineer", "Provided technical " +
                "leadership and consulting for a PCF fund system and its technology stack for onboarding vendors and " +
                "worked as a steward for project rewrite");
        resumeUserProfileDto.setSummarySkills(summarySkillsList);

        List<ResumeUserJobDto> resumeUserJobDtoList = new ArrayList<>();
        ResumeUserJobDto resumeUserJobDto = new ResumeUserJobDto();
        resumeUserJobDto.setCompany("American Express");
        resumeUserJobDto.setDesignation("Application Development Engineer");
        resumeUserJobDto.setStartDate(LocalDate.of(1999, 05, 01));
        resumeUserJobDto.setEndDate(LocalDate.of(2000, 06, 01));
        resumeUserJobDto.setCurrentJob(Boolean.FALSE);
        resumeUserJobDtoList.add(resumeUserJobDto);

        resumeUserJobDto = new ResumeUserJobDto();
        resumeUserJobDto.setCompany("Novell Express");
        resumeUserJobDto.setDesignation("Application Development Engineer");
        resumeUserJobDto.setStartDate(LocalDate.of(2000, 05, 01));
        resumeUserJobDto.setEndDate(LocalDate.of(2002, 10, 01));
        resumeUserJobDto.setCurrentJob(Boolean.FALSE);
        resumeUserJobDtoList.add(resumeUserJobDto);
        resumeUserProfileDto.setResumeUserJobList(resumeUserJobDtoList);

        ResumeUserEducationDto resumeUserEducationDto = new ResumeUserEducationDto();
        resumeUserEducationDto.setStartDate(LocalDate.of(2000, 06, 01));
        resumeUserEducationDto.setEndDate(LocalDate.of(2002, 10, 01));
        resumeUserEducationDto.setSummary("This is the ultimate Degree");
        resumeUserEducationDto.setCollege("MIT");
        resumeUserEducationDto.setQualification("Bachelors Degree");
        resumeUserProfileDto.setResumeUserEducationList(Arrays.asList(resumeUserEducationDto));
        return resumeUserProfileDto;
    }
}
