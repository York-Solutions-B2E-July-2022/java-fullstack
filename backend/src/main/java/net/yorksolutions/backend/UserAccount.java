package net.yorksolutions.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserAccount {
    @Id
    @JsonProperty
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @JsonProperty
    String username;
    @JsonProperty
    String password;
    public UserAccount(){

    }
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
