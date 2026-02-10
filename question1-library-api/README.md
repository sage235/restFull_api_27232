Name: Mr ASDODJI Le Sage

Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 1 – Library REST API
Description

This project is a simple Spring Boot REST API used to manage a library system.
It allows clients to add books, retrieve all books, retrieve a book by ID, and search for books by title.
The application uses an in-memory list to store book data.

How to Run the Application
Prerequisites

Java 17 or higher

Maven

Spring Boot

Run Commands
mvn clean install
mvn spring-boot:run


The application will start on:

http://localhost:8080

Base URL
/api/books

API Endpoints
1️. Get All Books

Method: GET

http://localhost:8080/api/books


Response (200 OK)

[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert Martin",
    "isbn": "978-0132350884",
    "year": 2008
  },
  {
    "id": 2,
    "title": "Effective Java",
    "author": "Joshua Block",
    "isbn": "978-0134685991",
    "year": 2018
  },
  {
    "id": 3,
    "title": "Spring in Action",
    "author": "Craig Walls",
    "isbn": "978-1617294945",
    "year": 2018
  }
]

2️. Get Book by ID

Method: GET

http://localhost:8080/api/books/{id}


Example

http://localhost:8080/api/books/1


Response (200 OK)

{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert Martin",
  "isbn": "978-0132350884",
  "year": 2008
}

3️. Search Book by Title

Method: GET

http://localhost:8080/api/books/search?title=spring


Response (200 OK)

[
  {
    "id": 3,
    "title": "Spring in Action",
    "author": "Craig Walls",
    "isbn": "978-1617294945",
    "year": 2018
  }
]

4️. Add a New Book

Method: POST

http://localhost:8080/api/books


Request Body

{
  "id": 4,
  "title": "Java Concurrency in Practice",
  "author": "Brian Goetz",
  "isbn": "978-0321349606",
  "year": 2006
}


Response (201 Created)

{
  "id": 4,
  "title": "Java Concurrency in Practice",
  "author": "Brian Goetz",
  "isbn": "978-0321349606",
  "year": 2006
}

5️. Delete a Book by ID

Method: DELETE

http://localhost:8080/api/books/{id}


Example

http://localhost:8080/api/books/2


Response (200 OK)

Book deleted successfully.

Testing

Tested using Postman

GET requests verified using a web browser

Correct HTTP status codes returned:

200 OK

201 Created

Status

 Completed and verified
