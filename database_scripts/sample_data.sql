insert into book_store.user (username, password, name, email_address, home_address)
values ('username1', 'password1', 'name1', 'email_address1', 'home_address1');


insert into book_store.author (author_pk, author_first_name, author_last_name, author_publisher, author_biography)
    value ('12345670', 'author_first_name1', 'author_last_name1', 'author_publisher1', 'author_biography1');


insert into book_store.book(book_isbn, book_name, book_description, book_publisher, book_year_published, book_genre, book_price, book_copies_sold, book_average_rating, author_pk)
    value ('1234567890120', 'book_name1', 'book_description1', 'book_publisher1', 2023, 'book_genre1', 10.00, 100, 4.5, '12345670');

insert into book_store.book(book_isbn, book_name, book_description, book_publisher, book_year_published, book_genre, book_price, book_copies_sold, book_average_rating, author_pk)
    value ('1234567890121', 'book_name2', 'book_description2', 'book_publisher1', 2023, 'book_genre1', 10.00, 100, 4.5, '12345670');


insert into book_store.shopping_cart(username, book_isbn)
    value ('username1', '1234567890120');


insert into book_store.credit_card(credit_card_number, credit_card_expiry_month, credit_card_expiry_year, credit_card_pin, name, billing_address, username)
    value ('1234567890123450', 01, 2026, 120, 'name1', 'billing_address1', 'username1');


insert into book_store.rating(username, book_isbn, book_rating, datestamp)
    value ('username1', '1234567890120', 4.5, '2023-01-01 00:00:01');


insert into book_store.comment (username, book_isbn, datestamp, comment)
values ('username1', '1234567890120', '2023-01-01 00:00:01', 'comment1');


insert into book_store.wishlist (wishlist_name, username, book_isbn)
    value ('wishlist_name1', 'username1', '1234567890120');

insert into book_store.wishlist (wishlist_name, username, book_isbn)
    value ('wishlist_name1', 'username1', '1234567890121');
