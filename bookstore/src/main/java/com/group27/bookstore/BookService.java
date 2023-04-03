package com.group27.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

	// gets list of all books
    public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

	// return a list of books genre.
	public List<Book> getByGenre(String genre) {
		List<Book> books = new ArrayList<>();
		bookRepository.findByGenre(genre).forEach(books::add);
		return books;
	}

	// gets list of top sellers and returns them in descending order
	public List<Book> getTopSellers() {
		return bookRepository.findTop10ByOrderByNumSoldDesc();
	}

	// returns a list of books by rating or higher
	public List<Book> getBooksByRating(double rating) {
		return bookRepository.findByRatingGreaterThanEqual(rating);
	}
	
	// gets a list of books by publisher. changes the price by the discountPercent
	public void discountBooksByPublisher(String publisher, double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            double price = book.getPrice();
            double discountAmount = price * (discountPercent / 100.0);
            book.setPrice(price - discountAmount);
            bookRepository.save(book);
        }
    }

	


}
