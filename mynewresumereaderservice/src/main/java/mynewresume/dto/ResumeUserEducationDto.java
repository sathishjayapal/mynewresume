package mynewresume.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@Getter
@Setter
public class ResumeUserEducationDto {
    private String college;
    private String qualification;
    private LocalDate startDate;
    private LocalDate endDate;
    private String summary;

}
