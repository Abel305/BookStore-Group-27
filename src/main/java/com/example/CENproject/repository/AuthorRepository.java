package com.example.CENproject.repository;

import com.example.CENproject.entity.Author;
import com.example.CENproject.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}