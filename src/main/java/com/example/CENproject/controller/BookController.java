package com.example.CENproject.controller;


import java.lang.Iterable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.CENproject.repository.AuthorRepository;
import com.example.CENproject.repository.BookRepository;
import com.example.CENproject.entity.Author;
import com.example.CENproject.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookController(final BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @GetMapping("/Books")
    public Iterable<Book> getBook() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/Books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer id) {
        return this.bookRepository.findById(id);
    }

    @GetMapping("/Authors/{id}/Books")
    public List<Book> getAuthorBooksById(@PathVariable("id") Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found"));
        return bookRepository.findByAuthor(author);
    }

    @PostMapping("/Books")
    public Book createNewBook(@RequestBody Book book){
        Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new BookNotFoundException("Author not found"));

        Book newBook = new Book();
        newBook.setISBN(book.getISBN());
        newBook.setBookName(book.getBookName());
        newBook.setBookDescription(book.getBookDescription());
        newBook.setPrice(book.getPrice());
        newBook.setAuthor(author);
        newBook.setGenre(book.getGenre());
        newBook.setPublisher(book.getPublisher());
        newBook.setYearPublished(book.getYearPublished());
        newBook.setCopiesSold(book.getCopiesSold());
        newBook.setQuantity(book.getQuantity());

        Book savedBook = this.bookRepository.save(newBook);
        return savedBook;
    }


}
