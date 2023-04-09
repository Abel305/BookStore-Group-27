package com.geek.text.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.text.entity.Book;
import com.geek.text.entity.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByBook(Book book);
}