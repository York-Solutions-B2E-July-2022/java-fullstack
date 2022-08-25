package net.yorksolutions.backend.service;

import net.yorksolutions.backend.models.UserAccount;
import net.yorksolutions.backend.models.UserDTO;
import net.yorksolutions.backend.models.UserProfile;
import net.yorksolutions.backend.models.repo.UserAccountRepo;
import net.yorksolutions.backend.models.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserAccountRepo userAccountRepo;
    private final UserProfileRepo userProfileRepo;
    @Autowired
    public UserService(UserAccountRepo userAccountRepo, UserProfileRepo userProfileRepo){
        this.userAccountRepo = userAccountRepo;
        this.userProfileRepo = userProfileRepo;
    }
    public void create(String username, String password) {
        if(userAccountRepo.existsByUsername(username)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
        UserAccount newuser = new UserAccount(username, password);
        userAccountRepo.save(newuser);
    }

    public void create(UserDTO userInfo) {
        if(userAccountRepo.existsByUsername(userInfo.getUsername())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");
        }
        UserProfile newUserProfile = new UserProfile(userInfo.getFirstName(), userInfo.getLastName());
        UserProfile savedUserProfile = this.userProfileRepo.save(newUserProfile);
        UserAccount newUser = new UserAccount(userInfo.getUsername(), userInfo.getPassword());
        newUser.setUserProfile(savedUserProfile);
        this.userAccountRepo.save(newUser);
    }
}
