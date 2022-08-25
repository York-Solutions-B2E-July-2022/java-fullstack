package net.yorksolutions.backend.service;

import net.yorksolutions.backend.models.UserAccount;
import net.yorksolutions.backend.models.repo.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserAccountRepo repo;
    private HashMap<UUID, UUID> tokenMap;

    @Autowired
    public AuthService(@NonNull UserAccountRepo repo){
        this.repo = repo;
        this.tokenMap = new HashMap<>();
    }
    public ResponseEntity<Void> checkAuth(UUID token){
        if(!tokenMap.containsKey(token)){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public UUID login(String username, String password){
        Optional<UserAccount> maybeUser = this.repo.findByUsernameAndPassword(username, password);
        if(maybeUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        UUID token = UUID.randomUUID();
        UserAccount user = maybeUser.get();
        this.tokenMap.put(token, user.getId());
        return token;
    }
    public void logout(UUID token){
        if(!tokenMap.containsKey(token))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TOKEN DOES NOT EXIST");
        tokenMap.remove(token);

    }



    public UserAccount userInfo(UUID token) {
        UUID loggedUser = this.tokenMap.get(token);
        Optional<UserAccount> maybeUser = repo.findById(loggedUser);
        if(maybeUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.GONE);
        }
        return maybeUser.get();
    }
}
