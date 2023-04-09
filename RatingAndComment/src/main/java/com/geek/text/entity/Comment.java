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
@Table(name = "comments") // Indicates that instances of this class will be stored in the "comments" table in MySql.
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // identifier for the comment
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; // user who posted the comment
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book; // book the comment is about
    private String comment; // text of the comment
    private Date date; // date when the comment was posted
    
    public Comment() {
    }
    
	public Comment(User user, Book book, String comment, Date date) {
		super();
		this.user = user;
		this.book = book;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

    
}
