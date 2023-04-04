package com.example.CENproject.entity;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Column;
//import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="BOOKS")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Column(name="ISBN")
    private String isbn;

    public String getISBN() {
        return this.isbn;
    }

    public void setISBN(String isbn){
        this.isbn = isbn;
    }


    @Column(name="BOOK_NAME")
    private String bookName;

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    @Column(name="BOOK_DESCRIPTION")
    private String bookDescription;

    public String getBookDescription() {
        return this.bookDescription;
    }

    public void setBookDescription(String bookDescription){
        this.bookDescription = bookDescription;
    }

    @Column(name="PRICE")
    private Double price;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "AUTHORS_ID")
    private Author author;

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author){
        this.author = author;
    }

    @Column(name="GENRE")
    private String genre;

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    @Column(name="PUBLISHER")
    private String publisher;

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    @Column(name="YEAR_PUBLISHED")
    private Integer yearPublished;

    public Integer getYearPublished() {
        return this.yearPublished;
    }

    public void setYearPublished(Integer yearPublished){
        this.yearPublished = yearPublished;
    }

    @Column(name="COPIES_SOLD")
    private Integer copiesSold;

    public Integer getCopiesSold() {
        return this.copiesSold;
    }

    public void setCopiesSold(Integer copiesSold){
        this.copiesSold = copiesSold;
    }

    @Column(name="AMOUNT")
    private int qty;

    public Integer getQuantity() {
        return this.qty;
    }

    public void setQuantity(Integer quantity){
        this.qty = quantity;
    }
}