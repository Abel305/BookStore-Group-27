import mysql.connector

if __name__ == '__main__':
    book_store_bd = mysql.connector.connect(
        host = "127.0.0.1",
        user = "root",
        password = "unsecure"
    )

    print(book_store_bd)

    cursor = book_store_bd.cursor()

    cursor.execute("SHOW DATABASE")

    for x in cursor:
        print(x)


# TODO: create an HTTP server
# TODO: create an HTTP client