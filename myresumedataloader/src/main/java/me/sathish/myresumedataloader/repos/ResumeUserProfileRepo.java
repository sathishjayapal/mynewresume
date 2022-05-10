package me.sathish.myresumedataloader.repos;

import me.sathish.myresumedataloader.models.ResumeUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeUserProfileRepo extends JpaRepository<ResumeUserProfile, Integer> {
    Optional<ResumeUserProfile> findByUserName(String userName);
}
