package com.group27.bookstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByGenre(String genre);
    
    List<Book> findTop10ByOrderByNumSoldDesc();
   
    List<Book> findByRatingGreaterThanEqual(double rating);

    List<Book> findByPublisher(String publisher);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.price = b.price * (1 - :discountPercent / 100.0) WHERE b.publisher = :publisher")
    void discountByPublisher(@Param("publisher") String publisher, @Param("discountPercent") Integer discountPercent);

    default void discountBooksByPublisherSafe(String publisherName, Integer discountPercent) {
        if (publisherName != null) {
            discountByPublisher(publisherName, discountPercent);
        }
    }

}
