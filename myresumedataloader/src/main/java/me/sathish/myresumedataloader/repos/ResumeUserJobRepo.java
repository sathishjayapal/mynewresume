package me.sathish.myresumedataloader.repos;

import me.sathish.myresumedataloader.models.ResumeUserJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeUserJobRepo extends JpaRepository<ResumeUserJob, Integer> {
}
