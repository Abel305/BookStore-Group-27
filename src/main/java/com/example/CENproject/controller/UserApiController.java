package com.example.CENproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CENproject.entity.User;
import com.example.CENproject.repository.UserRepo;

@RestController
public class UserApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getBookById(@PathVariable("id") Integer id) {
        return this.userRepo.findById(id);
    }

    @PostMapping(value = "/save")
    public String saveUser (@RequestBody User user) {
        userRepo.save(user);
        return "saved";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatUser = userRepo.findById(id).get();
        updatUser.setPassword(user.getPassword());
        updatUser.setFirstName(user.getFirstName());
        updatUser.setLastname(user.getLastname());
        updatUser.setHomeAddress(user.getHomeAddress());
        userRepo.save(updatUser);
        return "Updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "delet user id:" + id;
    }

}
