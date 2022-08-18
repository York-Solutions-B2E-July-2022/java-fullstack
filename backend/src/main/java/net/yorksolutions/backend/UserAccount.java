package net.yorksolutions.backend;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserAccount {
    @Id
    UUID id;
    String username;
    String password;
}
