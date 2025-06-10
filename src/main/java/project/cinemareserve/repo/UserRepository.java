package project.cinemareserve.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cinemareserve.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
