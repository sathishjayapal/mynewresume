package mynewresume.resume.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@Getter
@Setter
public class ResumeUserJobDto {
    private String company;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCurrentJob;
}
