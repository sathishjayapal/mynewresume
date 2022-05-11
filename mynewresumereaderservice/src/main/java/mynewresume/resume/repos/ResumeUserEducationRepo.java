package mynewresume.resume.repos;

import mynewresume.resume.models.ResumeUserEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeUserEducationRepo extends JpaRepository<ResumeUserEducation, Integer> {
}
