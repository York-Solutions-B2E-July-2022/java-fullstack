package net.yorksolutions.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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

    @OneToOne
    UserProfile userProfile;
    public UserAccount(){

    }
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UUID getId(){
       return this.id;
    }

    public void setUserProfile(UserProfile userProfile){
        this.userProfile = userProfile;
    }
}
