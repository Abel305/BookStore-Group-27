drop database if exists book_store;
create database book_store;

set foreign_key_checks = 0;


drop table if exists book_store.user;
create table book_store.user (
    username varchar(32) not null ,
    password varchar(32) not null ,
    name varchar(128),
    email_address varchar(128),
    home_address varchar(512),

    primary key (username)
);


drop table if exists book_store.author;
create table book_store.author (
    author_pk int not null ,
    author_first_name varchar(32) not null ,
    author_last_name varchar(32) not null ,
    author_publisher varchar(32) not null ,
    author_biography varchar(1024),

    primary key (author_pk)
);


drop table if exists book_store.book;
create table book_store.book (
    book_isbn varchar(13) not null ,

    book_name varchar(256) not null ,
    book_description varchar(1024),
    book_publisher varchar(128) not null ,
    book_year_published varchar(4),
    book_genre varchar(128) not null ,
    book_price float not null ,
    book_copies_sold int,
    book_average_rating float,

    primary key (book_isbn),

    # TODO: use to query the author details for display (first and last name)
    author_pk int not null ,
    foreign key (author_pk) references book_store.author(author_pk)
);


drop table if exists book_store.shopping_cart;
create table book_store.shopping_cart (
    username varchar(32) not null ,
    book_isbn varchar(13) not null ,

    foreign key (username) references book_store.user(username),
    foreign key (book_isbn) references book_store.book(book_isbn)

);


drop table if exists book_store.credit_card;
create table book_store.credit_card (
    credit_card_number varchar(16) not null ,
    credit_card_expiry_month int (2) not null ,
    credit_card_expiry_year int (4) not null ,
    credit_card_pin int(3) not null ,
    name varchar(128) not null ,
    billing_address varchar(512) not null ,

    primary key (credit_card_number),

    username varchar(32) not null,
     foreign key (username) references book_store.user(username)
);

drop table if exists book_store.rating;
create table book_store.rating (
    username varchar(32),
    book_isbn varchar(13),
    book_rating int,
    datestamp date,

    foreign key (username) references book_store.user(username),
    foreign key (book_isbn) references book_store.book(book_isbn)

    # TODO: add a trigger (on create and update) to ensure the value is from 1 to 5
    # TODO: add a trigger (on create and update) to update the average rating of the book
);

drop table if exists book_store.comment;
create table book_store.comment (
    username varchar(32),
    book_isbn varchar(13),
    datestamp date,
    comment varchar(1024),

    foreign key (username) references book_store.user(username),
    foreign key (book_isbn) references book_store.book(book_isbn)
);


drop table if exists book_store.wishlist;
create table book_store.wishlist (
    wishlist_name varchar(128) not null ,
    username varchar(128) not null ,
    book_isbn varchar(13) ,

    foreign key (username) references book_store.user(username),
    foreign key (book_isbn) references book_store.book(book_isbn)
);