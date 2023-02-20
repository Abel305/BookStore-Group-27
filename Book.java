package com.group27.group27;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Book{

    private int bookID;
    
    private String title;

    private String author;

    private String description;

    private String publisher;

    private int year;

    private String genre;

    private double price;

    private double rating;

    private int copiesSold;

}
