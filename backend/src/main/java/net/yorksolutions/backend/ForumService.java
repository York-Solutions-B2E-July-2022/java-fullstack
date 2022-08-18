package net.yorksolutions.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class ForumService {
    private final ForumThreadRepo repo;

    @Autowired
    public ForumService(@NonNull ForumThreadRepo repo){
        this.repo = repo;
    }
    public void create(UUID creator, String title, String description){
        if(repo.existsByTitle(title))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Forum with title already exists");
        ForumThread newforum = new ForumThread(creator, title, description);
        repo.save(newforum);
    }
    public Iterable<ForumThread> getList(){
        return repo.findAll();
    }
    public void getOne(){}

    public void edit(){

    }
    public void delete(){

    }
}