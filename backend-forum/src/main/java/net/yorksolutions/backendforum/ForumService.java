package net.yorksolutions.backendforum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
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

    public void edit(ForumThread thread){
        this.repo.save(thread);
    }
    public void delete(Long id){
        Optional<ForumThread> thread = this.repo.findById(id);
        if(thread.isEmpty())
            throw new ResponseStatusException(HttpStatus.GONE, "Id does not exist");
        this.repo.delete(thread.get());
    }
}
