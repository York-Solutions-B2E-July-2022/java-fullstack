package net.yorksolutions.backendforum.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ForumPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @JsonProperty
    UUID creator;
    @JsonProperty
    String body;

    public ForumPost(UUID creator, String body) {
        this.creator = creator;
        this.body = body;
    }

    public ForumPost() { }
}
