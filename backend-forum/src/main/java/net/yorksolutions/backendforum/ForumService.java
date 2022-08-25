package net.yorksolutions.backendforum;

import net.yorksolutions.backendforum.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class ForumService {
    private final ForumThreadRepo repo;
    private final RestTemplate restTemplate;
    @Value("${net.yorksolutions.backendforum.auth_url}")
    private String AUTH_URL ;
    @Autowired
    public ForumService(@NonNull ForumThreadRepo repo){

        this.repo = repo;
        this.restTemplate = new RestTemplate();
    }

    public Boolean checkAuth(UUID token){
        try {
            ResponseEntity<Void> response= this.restTemplate.getForEntity(AUTH_URL + "/checkAuth/"+ token, Void.class);
            return true;
        } catch (RestClientException e){
            return false;
        }
    }
    public UserModel getUserInfo(UUID token){
        ResponseEntity<UserModel> response= this.restTemplate.getForEntity(AUTH_URL + "/userInfo/"+ token, UserModel.class);
        return response.getBody();
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
