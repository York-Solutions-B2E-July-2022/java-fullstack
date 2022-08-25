package net.yorksolutions.backendforum.models.repo;

import net.yorksolutions.backendforum.models.ForumThread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumThreadRepo extends CrudRepository<ForumThread, Long> {
    Boolean existsByTitle(String title);
}
