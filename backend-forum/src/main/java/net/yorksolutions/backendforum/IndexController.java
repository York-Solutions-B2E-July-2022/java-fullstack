package net.yorksolutions.backendforum;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    //@GetMapping("/createForumThread")
    //public void createForumThread(
    //        @RequestParam UUID token,
    //        @RequestParam String title,
    //        @RequestParam String description){
    //    UUID loggedUser = this.authService.checkAuth(token);
    //    this.forumService.create(loggedUser, title, description);
    //}

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
