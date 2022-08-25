package net.yorksolutions.backendforum.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class ForumThread {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;
    @JsonProperty
    UUID creator;
    @JsonProperty
    String title;
    @JsonProperty
    String description;

    @OneToMany
    @JsonProperty
    List<ForumPost> forumPostList;
    public ForumThread(){}
    public ForumThread(UUID creator, String title, String description) {
        this.creator =  creator;
        this.title =title;
        this.description = description;
    }

    public List<ForumPost> getForumPostList() {
        return forumPostList;
    }

    public void setForumPostList(List<ForumPost> forumPostList) {
        this.forumPostList = forumPostList;
    }
}
