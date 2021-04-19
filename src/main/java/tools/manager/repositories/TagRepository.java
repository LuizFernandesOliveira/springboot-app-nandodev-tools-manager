package tools.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tools.manager.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
