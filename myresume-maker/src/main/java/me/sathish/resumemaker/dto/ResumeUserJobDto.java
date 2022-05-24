package me.sathish.resumemaker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

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
    private List<String> jobAccomplishments;
}
