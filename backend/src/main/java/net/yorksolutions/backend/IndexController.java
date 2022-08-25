package net.yorksolutions.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class IndexController {

    private final AuthService authService;
    @Autowired
    public IndexController(@NonNull AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, @RequestParam String password){
        return this.authService.login(username, password);
    }
    @GetMapping("/logout")
    public void logout(@RequestParam UUID token){
        this.authService.logout(token);
    }
    @GetMapping("/signup")
    public void signup(@RequestParam String username, @RequestParam String password){
        this.authService.signup(username, password);
    }
    @GetMapping("/checkAuth/{token}")
    public ResponseEntity<Void> checkAuth(@PathVariable UUID token){
        return this.authService.checkAuth(token);
    }
    @GetMapping("/userInfo/{token}")
    public UserAccount userInfo(@PathVariable UUID token){
        return this.authService.userInfo(token);
    }


}
