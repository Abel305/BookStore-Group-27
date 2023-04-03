package com.group27.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String publisher;

    @Column
    private String genre;

    @Column
    private String publicationDate;

    @Column
    private double price;

    @Column
    private double rating;

    @Column(name = "numSold", nullable=false) 
    private Integer numSold;

    @Column
    private String description;
        
    // default constructor
    public Book() {
        
    }

    public Book(int id, String title, String author, String publisher, String genre, String publicationDate, double price, double rating, Integer numSold, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.price = price;
        this.rating = rating;
        this.numSold = numSold;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Integer getNumSold() {
        return this.numSold;
    }

    public void setNumSold(Integer numSold) {
        this.numSold = numSold;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", genre=" + genre +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", rating=" + rating +
                ", numSold=" + numSold +
                ", description='" + description + '\'' +
                '}';
    }
}


