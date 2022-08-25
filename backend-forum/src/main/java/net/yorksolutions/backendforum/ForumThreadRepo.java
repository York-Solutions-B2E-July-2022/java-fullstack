package net.yorksolutions.backendforum;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumThreadRepo extends CrudRepository<ForumThread, Long> {
    Boolean existsByTitle(String title);
}
