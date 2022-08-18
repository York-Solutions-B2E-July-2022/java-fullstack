package net.yorksolutions.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
public class IndexController {

    private final AuthService service;
    @Autowired
    public IndexController(@NonNull AuthService service){
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, @RequestParam String password){
        return this.service.login(username, password);
    }
    @GetMapping("/logout")
    public void logout(){

    }
    @GetMapping("/signup")
    public void signup(){

    }
}
