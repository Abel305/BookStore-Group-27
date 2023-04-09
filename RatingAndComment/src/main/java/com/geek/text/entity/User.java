package com.geek.text.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "users") // Indicates that instances of this class will be stored in the "users" table in MySql.
public class User {
	
	@Id //specifies that the id field will be used as the primary key for this class.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // represents the primary key of this class.
    private String name; //represents the name of the user.
    private String email; //represents the email of the user.
    
   //Default constructor
	public User() {
	}
	
	//Parameterized constructor
	public User(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
