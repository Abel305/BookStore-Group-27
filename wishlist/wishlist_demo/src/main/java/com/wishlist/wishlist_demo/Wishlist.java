package com.wishlist.wishlist_demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private String wishlist_name;

    private String username;

    private String book_isbn;

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }
}