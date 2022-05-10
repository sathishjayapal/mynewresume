package mynewresume.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ResumeUserEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String college;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
    private String summary;

    @Override
    public String toString() {
        return "ResumeUserEducation{" +
                "id=" + id +
                ", college='" + college + '\'' +
                ", qualification='" + qualification + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", summary='" + summary + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
