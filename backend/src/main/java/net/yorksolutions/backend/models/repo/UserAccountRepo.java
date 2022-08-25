package net.yorksolutions.backend.models.repo;

import net.yorksolutions.backend.models.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, UUID> {
    Optional<UserAccount> findByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
