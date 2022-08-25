package net.yorksolutions.backendforum;

import net.yorksolutions.backendforum.models.PostDTO;
import net.yorksolutions.backendforum.service.AuthService;
import net.yorksolutions.backendforum.service.ForumService;
import net.yorksolutions.backendforum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class ForumPostController {

    private final AuthService authService;
    private final PostService postService;
    private final ForumService forumService;

    @Autowired
    public ForumPostController(@NonNull AuthService authService, @NonNull PostService postService, @NonNull ForumService forumService) {
        this.authService = authService;
        this.postService = postService;
        this.forumService = forumService;
    }

    @PostMapping
    public void add(@RequestParam UUID token, @RequestParam Long threadId, @RequestBody PostDTO postDTO){
        if(!authService.checkAuth(token))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        UUID loggedUser = authService.getUserInfo(token).id;
        this.postService.add(loggedUser, threadId, postDTO);
    }
}
