package com.geek.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geek.text.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	
}
