package tools.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tools.manager.models.Tool;
import tools.manager.models.User;

import java.util.List;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {
    public List<Tool> findAllByUser(User user);
}
