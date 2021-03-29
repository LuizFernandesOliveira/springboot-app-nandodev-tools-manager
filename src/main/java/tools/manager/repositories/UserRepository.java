package tools.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tools.manager.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
