package com.geek.text.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.text.dto.CommentDto;
import com.geek.text.entity.Book;
import com.geek.text.entity.Comment;
import com.geek.text.entity.User;
import com.geek.text.exception.ResourceNotFoundException;
import com.geek.text.repository.BookRepository;
import com.geek.text.repository.CommentRepository;
import com.geek.text.repository.UserRepository;


@RestController
@RequestMapping("/{bookId}/comments")
public class CommentController {


	// Inject CommentRepository, UserRepository, and BookRepository instances into the controller
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final BookRepository bookRepository;
	
	// Constructor-based dependency injection
	public CommentController(CommentRepository commentRepository, UserRepository userRepository, BookRepository bookRepository) {
		this.commentRepository = commentRepository;
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
	}

	// POST end-point for creating a new comment on a book
	@PostMapping("/createComment")
	public ResponseEntity<?> createComment(@PathVariable Integer bookId, @RequestBody CommentDto commentDto) {

		// Retrieve the user by ID from the UserRepository, or throw a ResourceNotFoundException if not found
		User user = userRepository.findById(commentDto.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));

		// Retrieve the book by ID from the BookRepository, or throw a ResourceNotFoundException if not found
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

		// Create a new Comment object with the retrieved user, book, comment, and the current date
		Comment comment = new Comment(user, book, commentDto.getComment(), new Date());

		// Save the comment to the CommentRepository
		commentRepository.save(comment);

		// Return a response entity with a status of CREATED
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// GET end-point for retrieving all comments on a book
	@GetMapping("/getComments")
	public ResponseEntity<?> getComments(@PathVariable Integer bookId) {

		// Retrieve the book by ID from the BookRepository or throw a ResourceNotFoundException 
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

		// Retrieve all comments on the book from the CommentRepository
		List<Comment> comments = commentRepository.findByBook(book);

		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

}
