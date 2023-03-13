package com.group27.group27;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;
    
     @GetMapping("/version")
    public String getAppDetails() {
        return appName + " " + appVersion;
    }

    @GetMapping("/bookdatabase")
    public String bookDB_api() {
        return "Books placed here: ";
    }

    // gets individual book by title
    //localhost:8080/bookdatabase/Hamlet
    @GetMapping("/bookdatabase/{title}")
    public String getBook(@PathVariable("title") String title) {
        return "Fetching the book details for the title: " + title;
    }

    @PostMapping("/bookdatabase")
    public String saveBook(@RequestBody Book book) {
        return "Saving the book details to the database " + book;
    }

    @DeleteMapping
    public String deleteBook(@RequestParam String title) {
        return "Deleting the book details for title " + title;
    }

}
