package com.geek.text.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books") // Indicates that instances of this class will be stored in the "books" table in MySql.
public class Book {
	@Id // Indicates that the "id" field of this class is the primary identifier for a book object.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates key
    private Integer id;
    private String title; // The title of the book.
    private String author; // The author.
    private String description; // The description of the book.
    private double price; // The price of the book.
    

    //Getters and Setters
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
    
}
