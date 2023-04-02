package com.geek.text.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "ratings")   // Indicates that instances of this class will be stored in the "ratings" table in MySql.
public class Rating {
    @Id                            	// marks the field below as the identifier for the document
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
	@JoinColumn(name = "user_id")
	private User user; 				// user who posted the comment
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book; 				// book the comment is about
    private int rating;            	// the rating given by the user to the book
    private Date date;             	// the date on which the rating was given
    
    //Default Constructor
    public Rating() {
    	
    }
    
    //Parameterized Constructor
	public Rating(User user, Book book, int rating, Date date) {
		super();
		this.user = user;
		this.book = book;
		this.rating = rating;
		this.date = date;
	}
	
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

    
}
