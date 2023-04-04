package com.example.CENproject.controller;


import com.example.CENproject.repository.AuthorRepository;
import com.example.CENproject.entity.Author;
import com.example.CENproject.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/Authors")
    public Author createNewAuthor(@RequestBody Author author){
        Author newAuthor = this.authorRepository.save(author);
        return newAuthor;
    }


}