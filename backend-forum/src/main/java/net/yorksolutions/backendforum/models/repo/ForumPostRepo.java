package net.yorksolutions.backendforum.models.repo;

import net.yorksolutions.backendforum.models.ForumPost;
import net.yorksolutions.backendforum.models.ForumThread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumPostRepo extends CrudRepository<ForumPost, Long> {
}
