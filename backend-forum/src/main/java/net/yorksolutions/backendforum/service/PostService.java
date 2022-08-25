package net.yorksolutions.backendforum.service;

import net.yorksolutions.backendforum.models.ForumPost;
import net.yorksolutions.backendforum.models.ForumThread;
import net.yorksolutions.backendforum.models.PostDTO;
import net.yorksolutions.backendforum.models.repo.ForumPostRepo;
import net.yorksolutions.backendforum.models.repo.ForumThreadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    ForumThreadRepo forumThreadRepo;
    ForumPostRepo forumPostRepo;
    @Autowired
    public PostService(@NonNull ForumThreadRepo forumThreadRepo, @NonNull ForumPostRepo forumPostRepo) {
        this.forumPostRepo = forumPostRepo;
        this.forumThreadRepo = forumThreadRepo;
    }


    public void add(UUID creator, Long threadId, PostDTO postDTO) {
        Optional<ForumThread> maybeThread = this.forumThreadRepo.findById(threadId);
        if(maybeThread.isEmpty())
            throw new ResponseStatusException(HttpStatus.GONE);
        ForumThread thread = maybeThread.get();
        List<ForumPost> orig = thread.getForumPostList();
        ArrayList<ForumPost> newList = new ArrayList(orig);
        ForumPost newPost = new ForumPost(creator, postDTO.body);
        newList.add(this.forumPostRepo.save(newPost));
        thread.setForumPostList(newList);
        forumThreadRepo.save(thread);
    }
}
