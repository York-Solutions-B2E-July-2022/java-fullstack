package net.yorksolutions.backendforum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class IndexController {
    private final ForumService forumService;
    @Autowired
    public IndexController(@NonNull ForumService forumService){
        this.forumService = forumService;
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
        if(this.forumService.checkAuth(token)){
            UUID loggedUser = this.forumService.getUserInfo(token).id;
            this.forumService.create(loggedUser, title, description);

        } else {
           throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    //@GetMapping("/forumThreads")
    //public Iterable<ForumThread> forumThreads(){
    //    return this.forumService.getList();
    //}

    //@PostMapping("/editForumThreads")
    //public void editForumThreads(@RequestParam UUID token, @RequestBody ForumThread thread){
    //    this.authService.checkAuth(token);
    //    this.forumService.edit(thread);
    //}
    //@DeleteMapping("/deleteForumThreads")
    //public void deleteForumThreads(@RequestParam UUID token, @RequestParam Long id){
    //    this.authService.checkAuth(token);
    //    this.forumService.delete(id);
    //}
}
