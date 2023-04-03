Book Browsing and Sorting Feature

THE HOME PAGE:
    http://localhost:8080

List of all Books:
    http://localhost:8080/GeekText/books

HTTP GET by Genre:
    Given a specific genre, return a list of books for that genre
   http://localhost:8080/GeekText/genre?genre={genre selection here}

HTTP GET by Top Sellers: 
    Return the top 10 books that have sold the most copies in descending order
    http://localhost:8080/GeekText/topsellers

HTTP GET by Rating:  
    Filter by rating higher or equal to the passed rating value.
    http://localhost:8080/GeekText/rating?rating={rating selection here}

HTTP Patch Request: 
    Update the price of all books under a publisher by a discount percent.
    http://localhost:8080/GeekText/discount/publisher/%7Bpublisher%7D?discountPercentage=10.0