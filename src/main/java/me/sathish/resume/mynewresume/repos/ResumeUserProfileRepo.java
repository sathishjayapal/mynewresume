package me.sathish.resume.mynewresume.repos;

import me.sathish.resume.mynewresume.models.ResumeUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeUserProfileRepo extends JpaRepository<ResumeUserProfile, Integer> {
    Optional<ResumeUserProfile> findByUserName(String userName);
}
