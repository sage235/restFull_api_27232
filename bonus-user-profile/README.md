Name: Mr ASDODJI Le Sage

Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 6 – User Profile REST API
Description

This Spring Boot REST API manages user profiles with full CRUD capabilities.
It supports searching by username, country, and age range, activating/deactivating profiles, and returning custom responses wrapped in a response object.

The application uses an in-memory list to store user profiles.

How to Run the Application
Prerequisites

Java 17+

Maven

Spring Boot

Run Commands
mvn clean install
mvn spring-boot:run


The application runs on:

http://localhost:8080

Base URL
/api/users


API Endpoints
1️. Get All Users

Method: GET

/api/users


Response (200 OK)

[
  {
    "id": 1,
    "username": "john_doe",
    "fullName": "John Doe",
    "email": "john@example.com",
    "age": 76,
    "country": "Rwanda",
    "bio": "Software Engineering student",
    "active": true
  },
  {
    "id": 2,
    "username": "alice_m",
    "fullName": "Alice",
    "email": "alice@example.com",
    "age": 2,
    "country": "Rwanda",
    "bio": "Web developer",
    "active": true
  },
  {
    "id": 3,
    "username": "paul_k",
    "fullName": "Paul Kagame",
    "email": "paul@example.com",
    "age": 70,
    "country": "Tchad",
    "bio": "Tech enthusiast",
    "active": false
  }
]

2️. Get User by ID

Method: GET

/api/users/{id}


Response (200 OK)

{
  "id": 1,
  "username": "john_doe",
  "fullName": "John Doe",
  "email": "john@example.com",
  "age": 76,
  "country": "Rwanda",
  "bio": "Software Engineering student",
  "active": true
}

3️. Create a New User

Method: POST

/api/users


Request Body

{
  "username": "maria_k",
  "email": "maria@example.com",
  "fullName": "Maria K",
  "age": 25,
  "country": "Rwanda",
  "bio": "UI Designer",
  "active": true
}


Response (201 Created)

{
  "message": "User created successfully",
  "data": {
    "id": 4,
    "username": "maria_k",
    "fullName": "Maria K",
    "email": "maria@example.com",
    "age": 25,
    "country": "Rwanda",
    "bio": "UI Designer",
    "active": true
  }
}

4️. Update User Profile

Method: PUT

/api/users/{id}


Response (200 OK)

{
  "message": "User updated successfully",
  "data": {
    "id": 2,
    "username": "alice_m",
    "fullName": "Alice Updated",
    "email": "alice_new@example.com",
    "age": 3,
    "country": "Rwanda",
    "bio": "Full-stack developer",
    "active": true
  }
}

5️. Delete User

Method: DELETE

/api/users/{id}


Response (204 No Content)

6️. Activate/Deactivate User

Method: PATCH

/api/users/{id}/toggle


Response (200 OK)

{
  "message": "User profile status updated",
  "data": {
    "id": 3,
    "username": "paul_k",
    "active": true
  }
}

7️. Search by Username

Method: GET

/api/users/search/username?username=john


Response (200 OK)

[
  {
    "id": 1,
    "username": "john_doe",
    "fullName": "John Doe",
    "age": 76,
    "country": "Rwanda",
    "active": true
  }
]

8️. Search by Country

Method: GET

/api/users/search/country?country=Rwanda


Response (200 OK)

[
  {
    "id": 1,
    "username": "john_doe",
    "fullName": "John Doe",
    "age": 76,
    "country": "Rwanda",
    "active": true
  },
  {
    "id": 2,
    "username": "alice_m",
    "fullName": "Alice",
    "age": 2,
    "country": "Rwanda",
    "active": true
  }
]

9️. Search by Age Range

Method: GET

/api/users/search/age?minAge=20&maxAge=80


Response (200 OK)

[
  {
    "id": 1,
    "username": "john_doe",
    "fullName": "John Doe",
    "age": 76,
    "country": "Rwanda",
    "active": true
  },
  {
    "id": 3,
    "username": "paul_k",
    "fullName": "Paul Kagame",
    "age": 70,
    "country": "Tchad",
    "active": false
  }
]

Testing

Verified all endpoints using Postman

CRUD, PATCH, and search endpoints behave correctly

Correct HTTP status codes returned (200, 201, 204)

Status

 Completed and verified
