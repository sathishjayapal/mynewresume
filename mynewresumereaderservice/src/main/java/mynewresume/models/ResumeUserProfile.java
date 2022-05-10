package mynewresume.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class ResumeUserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String theme;
    private String summary;
    private String name;
    private String phone;
    private String twitterHandle;
    private String gitHubRepo;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "job_id")
    List<ResumeUserJob> resumeUserJobList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resume_user_education_id")
    List<ResumeUserEducation> resumeUserEducationList = new ArrayList<>();
    @ElementCollection(targetClass = String.class)
    List<String> keySkills = new ArrayList<>();

    public List<String> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(List<String> keySkills) {
        this.keySkills = keySkills;
    }

    public List<ResumeUserEducation> getResumeUserEducationList() {
        return resumeUserEducationList;
    }

    public void setResumeUserEducationList(List<ResumeUserEducation> resumeUserEducationList) {
        this.resumeUserEducationList = resumeUserEducationList;
    }

    public List<ResumeUserJob> getResumeUserJobList() {
        return resumeUserJobList;
    }

    public void setResumeUserJobList(List<ResumeUserJob> resumeUserJobList) {
        this.resumeUserJobList = resumeUserJobList;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getGitHubRepo() {
        return gitHubRepo;
    }

    public void setGitHubRepo(String gitHubRepo) {
        this.gitHubRepo = gitHubRepo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "ResumeUserProfile{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", theme='" + theme + '\'' +
                ", summary='" + summary + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", twitterHandle='" + twitterHandle + '\'' +
                ", gitHubRepo='" + gitHubRepo + '\'' +
                ", resumeUserJobList=" + resumeUserJobList +
                '}';
    }
}
