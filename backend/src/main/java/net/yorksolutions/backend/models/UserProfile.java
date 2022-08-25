package net.yorksolutions.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @JsonProperty
    String firstName;
    @JsonProperty
    String lastName;

    public UserProfile(){}
    public UserProfile(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
