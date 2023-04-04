package com.example.CENproject.entity;

import com.example.CENproject.repository.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="AUTHORS")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Author {

    public Author(){

    }

    public Author(Number id) {
        System.out.println((int) id.longValue());
        this.id = (int) id.longValue();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="FIRST_NAME")
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Column(name="LAST_NAME")
    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Column(name="BIOGRAPHY")
    private String biography;

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String biography){
        this.biography = biography;
    }

    @Column(name="PUBLISHER")
    private String publisher;

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
}