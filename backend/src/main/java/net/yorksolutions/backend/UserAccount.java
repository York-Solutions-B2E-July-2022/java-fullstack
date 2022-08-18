package net.yorksolutions.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String username;
    String password;
    public UserAccount(){

    }
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
