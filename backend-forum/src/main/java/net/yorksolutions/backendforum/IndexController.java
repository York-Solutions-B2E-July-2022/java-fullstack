package net.yorksolutions.backendforum;

import net.yorksolutions.backendforum.models.ForumThread;
import net.yorksolutions.backendforum.service.AuthService;
import net.yorksolutions.backendforum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/")
public class IndexController {
    private final ForumService forumService;
    private final AuthService authService;
    @Autowired
    public IndexController(@NonNull ForumService forumService, @NonNull AuthService authService){
        this.forumService = forumService;
        this.authService = authService;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/createForumThread")
    public void createForumThread(
            @RequestParam UUID token,
            @RequestParam String title,
            @RequestParam String description){
        if(!this.authService.checkAuth(token))
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        UUID loggedUser = this.authService.getUserInfo(token).id;
        this.forumService.create(loggedUser, title, description);
    }

    @GetMapping("/forumThreads")
    public Iterable<ForumThread> forumThreads(){
        return this.forumService.getList();
    }

    @PostMapping("/editForumThreads")
    public void editForumThreads(@RequestParam UUID token, @RequestBody ForumThread thread){
        if(!this.authService.checkAuth(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        this.forumService.edit(thread);
    }
    @DeleteMapping("/deleteForumThreads")
    public void deleteForumThreads(@RequestParam UUID token, @RequestParam Long id){
        if(!this.authService.checkAuth(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        this.forumService.delete(id);
    }
}
