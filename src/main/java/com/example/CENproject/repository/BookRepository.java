package com.example.CENproject.repository;

import com.example.CENproject.entity.Author;
import com.example.CENproject.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthor(Author author);

}
