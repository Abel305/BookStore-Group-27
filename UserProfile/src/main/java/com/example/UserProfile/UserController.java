package com.example.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private userRepository userRepository;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            existingUser.setUsername(existingUser.getUsername());
            existingUser.setPassword(existingUser.getPassword());
            existingUser.setName(existingUser.getName());
            existingUser.setEmailAddress(existingUser.getEmailAddress());
            existingUser.setHomeAddress(existingUser.getHomeAddress());
            userRepository.save(existingUser);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

