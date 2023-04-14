package com.demo.userprofilem;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.userprofilem.User;
import com.demo.userprofilem.UserService;
import com.demo.userprofilem.CreditCard;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }



    @GetMapping("{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{username}")

    public ResponseEntity<User> updateUser(@PathVariable("username") String username,
                                           @RequestBody User user) {
        User updatedUser = userService.updateUser(username, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    // Build Create Credit Card REST API
    @PostMapping("{username}/credit_cards")

    public ResponseEntity<CreditCard> createCreditCard(@PathVariable("username") String username, @RequestBody CreditCard creditCard) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        else{
        CreditCard savedCreditCard = userService.createCreditCard(username, creditCard);
        return new ResponseEntity<>(savedCreditCard, HttpStatus.CREATED);
    }

}}

