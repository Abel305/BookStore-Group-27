package com.geek.text.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geek.text.entity.Book;
import com.geek.text.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByBook(Book book);
}