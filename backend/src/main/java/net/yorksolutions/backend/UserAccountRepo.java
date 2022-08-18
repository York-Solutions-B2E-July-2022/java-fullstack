package net.yorksolutions.backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepo extends CrudRepository<UserAccount, UUID> {
    Optional<UserAccount> findByUsernameAndPassword(String username, String password);
    Boolean existsByUsername(String username);
}
