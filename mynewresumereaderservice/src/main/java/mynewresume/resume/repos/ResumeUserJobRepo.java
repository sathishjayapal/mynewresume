package mynewresume.resume.repos;

import mynewresume.resume.models.ResumeUserJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeUserJobRepo extends JpaRepository<ResumeUserJob, Integer> {
}
