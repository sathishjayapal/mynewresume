package mynewresume.security.repos;

import mynewresume.security.models.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SecurityUser, Integer> {
    Optional<SecurityUser> findByUserName(String userName);
}
