package com.group27.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/GeekText")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "books.html";
    }
  
    @GetMapping("/books") 
    public List<Book> getBooks() {
        return bookService.getBooks();
    }  

    @RequestMapping(value = "/genre", method = RequestMethod.GET)
    public List<Book> getBooksByGenre(@RequestParam(value = "genre") String genre) {
        List<Book> bookGenre = bookService.getByGenre(genre);
        return bookGenre;
    }

    @RequestMapping(value = "/topsellers", method = RequestMethod.GET)
    public List<Book> getTopSellers() {
        List<Book> topSellers = bookService.getTopSellers();
        return topSellers;
    }

    @GetMapping("/rating")
    public List<Book> getBooksByRating(@RequestParam("rating") double rating) {
        return bookService.getBooksByRating(rating);
    }

    @PatchMapping("/discount")
    public ResponseEntity<String> discountBooksByPublisher(@RequestParam("publisher") String publisher,
                                                        @RequestParam("discountPercent") double discountPercent) {
        bookService.discountBooksByPublisher(publisher, discountPercent);
        return ResponseEntity.ok("Discount applied successfully!");
    }

}
