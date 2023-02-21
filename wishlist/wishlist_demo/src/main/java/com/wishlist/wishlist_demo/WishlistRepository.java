package com.wishlist.wishlist_demo;

import org.springframework.data.repository.CrudRepository;
import com.wishlist.wishlist_demo.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Integer> {

}