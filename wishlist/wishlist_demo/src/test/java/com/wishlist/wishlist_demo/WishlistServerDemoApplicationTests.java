package com.wishlist.wishlist_demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WishlistServerDemoApplicationTests {

	@Autowired
	private MainController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllWishlistItems() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/wishlist/get_wishlists", String.class))
				.contains(
						"[{\"wishlist_name\":\"wishlist_name1\",\"username\":\"username1\",\"book_isbn\":\"1234567890120\"}," +
						"{\"wishlist_name\":\"wishlist_name1\",\"username\":\"username1\",\"book_isbn\":\"1234567890120\"}]"
				);
	}
}