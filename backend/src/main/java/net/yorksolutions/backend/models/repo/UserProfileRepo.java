package net.yorksolutions.backend.models.repo;

import net.yorksolutions.backend.models.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends CrudRepository<UserProfile, Long> {
}
