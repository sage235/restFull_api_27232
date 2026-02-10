
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

# Question 1 – Library REST API

##  Description
This project is a simple Spring Boot REST API used to manage a library system.
It allows clients to add books, retrieve all books, and search for books by title.

---

##  How to Run the Application

### Prerequisites
- Java 17+
- Maven
- Spring Boot

### Run Commands
```bash
mvn clean install
mvn spring-boot:run
The application will start on:

http://localhost:8080
 Base URL
/api/books

 API Endpoints

1️. Get All Books
GET

http://localhost:8080/api/books
Response (200 OK)

[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin"
  }
]
2️. Get Book by ID
GET

http://localhost:8080/api/books/{id}
Example

http://localhost:8080/api/books/1
Response (200 OK)

{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin"
}
3️. Search Book by Title
GET

http://localhost:8080/api/books/search?title=clean
Response (200 OK)

[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin"
  }
]
4️. Add a New Book
POST

http://localhost:8080/api/books
Request Body

{
  "id": 2,
  "title": "Effective Java",
  "author": "Joshua Bloch"
}
Response (201 Created)

{
  "id": 2,
  "title": "Effective Java",
  "author": "Joshua Bloch"
}
 Testing
Tested using Postman

GET requests verified using a web browser

Correct HTTP status codes returned (200, 201)

Status

 Completed and verified

