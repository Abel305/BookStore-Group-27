package com.geek.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geek.text.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
