package net.yorksolutions.backend;

import net.yorksolutions.backend.models.UserAccount;
import net.yorksolutions.backend.models.UserDTO;
import net.yorksolutions.backend.service.AuthService;
import net.yorksolutions.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin
public class IndexController {

    private final AuthService authService;
    private final UserService userService;
    @Autowired
    public IndexController(@NonNull AuthService authService, @NonNull UserService userService){
        this.authService = authService;
        this.userService = userService;
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
    @PostMapping("/signup")
    public void signup(@RequestBody UserDTO userInfo ){
        this.userService.create(userInfo);
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
