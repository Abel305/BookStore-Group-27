--@block
CREATE TABLE Users(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    address TEXT,
    homeAddress TEXT
);
--@block
CREATE TABLE Authors(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    first VARCHAR(255),
    last VARCHAR(255),
    bio TEXT,
    publisher Text
);
--@block
CREATE TABLE Books(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    isbn VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2),
    author_id INT,
    genre VARCHAR(255),
    publisher VARCHAR(255),
    year YEAR,
    sold INT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

--@block
CREATE TABLE Comments(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    comment TEXT,
    rating TINYINT UNSIGNED NOT NULL
    CHECK (rating >= 0 AND rating <= 5),

    dateStamp Date NOt NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (book_id) REFERENCES Books(id)
);
--@block
CREATE TABLE WishList(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    list TINYINT UNSIGNED NOT NULL
    CHECK (list >= 1 AND list <= 3),

    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (book_id) REFERENCES Books(id)
);
--@block
CREATE TABLE Carts(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id)
);
--@block
CREATE TABLE CartItems(
    id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    cart_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (book_id) REFERENCES Books(id),
    FOREIGN KEY (cart_id) REFERENCES Carts(id)
);



--@block
INSERT INTO Users (username, password)
VALUES('Slug', '1234');
--@block
SELECT username,
    password
From Users;
--@block
CREATE INDEX username_index ON Users(username);
--@block
SET foreign_key_checks = 0;
DROP TABLE authors;
DROP TABLE books;
DROP TABLE cartitems;
DROP TABLE carts;
DROP TABLE comments;
DROP TABLE users;
DROP TABLE wishlist;
SET foreign_key_checks = 1;

