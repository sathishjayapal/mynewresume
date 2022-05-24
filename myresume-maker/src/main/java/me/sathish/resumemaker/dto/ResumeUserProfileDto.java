package me.sathish.resumemaker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Getter
@Setter
public class ResumeUserProfileDto {
    private int id;
    private String userName;
    private String theme;
    private String summary;
    private String name;
    private String phone;
    private String email;
    private String twitterHandle;
    private String gitHubRepo;
    private List<String> summarySkills;
    private List<String> keySkills;
    private List<ResumeUserJobDto> resumeUserJobList;
    private List<ResumeUserEducationDto> resumeUserEducationList;
}
