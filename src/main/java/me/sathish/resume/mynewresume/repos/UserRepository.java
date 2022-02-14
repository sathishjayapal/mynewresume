package me.sathish.resume.mynewresume.repos;

import me.sathish.resume.mynewresume.models.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SecurityUser, Integer> {
    Optional<SecurityUser> findByUserName(String userName);
}
