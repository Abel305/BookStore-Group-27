package com.geek.text.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.text.dto.RatingDto;
import com.geek.text.entity.Book;
import com.geek.text.entity.Rating;
import com.geek.text.entity.User;
import com.geek.text.exception.ResourceNotFoundException;
import com.geek.text.repository.BookRepository;
import com.geek.text.repository.RatingRepository;
import com.geek.text.repository.UserRepository;

@RestController
@RequestMapping("/{bookId}/ratings")
public class RatingController {
	
	// Inject CommentRepository, UserRepository, and BookRepository instances into the controller
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    // Constructor-based dependency injection
    @Autowired
    public RatingController(RatingRepository ratingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    // Create a new rating
    @PostMapping("/createRating")
    public ResponseEntity<?> createRating(@PathVariable Integer bookId, @RequestBody RatingDto ratingDto) {
        // Get user by id from the user repository
        User user = userRepository.findById(ratingDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // Get book by id from the book repository
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        // Create a new rating object and save it to the rating repository
        Rating rating = new Rating(user, book, ratingDto.getRating(), new Date());
        ratingRepository.save(rating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Get the average rating for a book
    @GetMapping("/average")
    public ResponseEntity<?> getAverageRating(@PathVariable Integer bookId) {
        // Get book by id from the book repository
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        // Get all the ratings for the book from the rating repository
        List<Rating> ratings = ratingRepository.findByBook(book);
        // Create a map to store the average rating
        Map<String, Object> avgRating = new HashMap<>();
        // If there are no ratings, set the average rating to 0.0
        if (ratings.isEmpty()) {
        	avgRating.put("averageRating", 0.0);
        }else {
        	// Compute the average rating and set it in the map
        	avgRating.put("averageRating", ratings.stream().mapToInt(Rating::getRating).average().getAsDouble());
        }
        return new ResponseEntity<>(avgRating, HttpStatus.OK);
    }
}