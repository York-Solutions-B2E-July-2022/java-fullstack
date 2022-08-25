package net.yorksolutions.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty
    String username;
    @JsonProperty
    String password;
    @JsonProperty
    String firstName;
    @JsonProperty
    String lastName;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
