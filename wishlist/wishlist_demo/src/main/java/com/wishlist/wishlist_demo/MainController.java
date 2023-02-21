package com.wishlist.wishlist_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/wishlist")
public class MainController {
    @Autowired
    private WishlistRepository wishlistRepository;

    @PostMapping(path="/create_wishlist") // map only POST requests
    public @ResponseBody String createWishlist (
            @RequestParam String wishlist_name,
            @RequestParam String username,
            @RequestParam String book_isbn) {

        Wishlist w = new Wishlist();
        w.setWishlist_name(wishlist_name);
        w.setUsername(username);
        w.setBook_isbn(book_isbn);

        return "Saved";
    }

    @GetMapping(path="/get_wishlists")
    public @ResponseBody Iterable<Wishlist> getAllUserWishlists() {
        return wishlistRepository.findAll();
    }
}