package com.example.CENproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CENproject.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findById(Integer id);
    
}
