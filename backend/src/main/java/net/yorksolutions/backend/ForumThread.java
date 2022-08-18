package net.yorksolutions.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ForumThread {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @JsonProperty
    UUID creator;
    @JsonProperty
    String title;
    @JsonProperty
    String description;

    public ForumThread(){}
    public ForumThread(UUID creator, String title, String description) {
        this.creator =  creator;
        this.title =title;
        this.description = description;
    }
}
