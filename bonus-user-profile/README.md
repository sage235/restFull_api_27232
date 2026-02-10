
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

bonus-user-profile/README.md
# Bonus – User Profile Management REST API

##  Description
This Spring Boot REST API manages user profiles.  
It supports:
- Basic CRUD operations (Create, Read, Update, Delete)
- Searching by username, country, or age range
- Activating/deactivating user profiles
- Returning custom response messages using a response wrapper (`ApiResponse<T>`)

---

##  How to Run the Application

### Prerequisites
- Java 17+ or Java 21
- Maven
- Spring Boot

### Run Commands
```bash
mvn clean install
mvn spring-boot:run


The application runs on:

http://localhost:8080

 Base URL
/api/users

 API Endpoints
1️. Get All User Profiles

GET

/api/users


Response (200 OK)

{
  "success": true,
  "message": "All user profiles retrieved successfully",
  "data": [
    {
      "userId": 1,
      "username": "john_doe",
      "email": "john@example.com",
      "fullName": "John Doe",
      "age": 25,
      "country": "Rwanda",
      "bio": "Software student",
      "active": true
    }
  ]
}

2️. Get User Profile by ID

GET

/api/users/{userId}


Response (200 OK)

{
  "success": true,
  "message": "User profile retrieved successfully",
  "data": {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com",
    "fullName": "John Doe",
    "age": 25,
    "country": "Rwanda",
    "bio": "Software student",
    "active": true
  }
}

3️. Create New User Profile

POST

/api/users


Request Body

{
  "username": "alice123",
  "email": "alice@example.com",
  "fullName": "Alice Smith",
  "age": 22,
  "country": "Kenya",
  "bio": "Frontend developer",
  "active": true
}


Response (201 Created)

{
  "success": true,
  "message": "User profile created successfully",
  "data": {
    "userId": 2,
    "username": "alice123",
    "email": "alice@example.com"
  }
}

4️. Update User Profile

PUT

/api/users/{userId}


Request Body

{
  "username": "alice_smith",
  "email": "alice_new@example.com",
  "fullName": "Alice Smith",
  "age": 23,
  "country": "Kenya",
  "bio": "Frontend & Backend Developer",
  "active": true
}


Response (200 OK)

{
  "success": true,
  "message": "User profile updated successfully",
  "data": {
    "userId": 2,
    "username": "alice_smith",
    "email": "alice_new@example.com"
  }
}

5️. Delete User Profile

DELETE

/api/users/{userId}


Response (204 No Content)

6️. Search User Profiles

GET

/api/users/search


Query Parameters (optional, any combination)

username – Filter by username

country – Filter by country

minAge / maxAge – Filter by age range

Example

/api/users/search?country=Kenya&minAge=20&maxAge=25


Response (200 OK)

{
  "success": true,
  "message": "User profiles filtered successfully",
  "data": [
    {
      "userId": 2,
      "username": "alice_smith",
      "email": "alice_new@example.com",
      "fullName": "Alice Smith",
      "age": 23,
      "country": "Kenya",
      "bio": "Frontend & Backend Developer",
      "active": true
    }
  ]
}

7️. Activate/Deactivate User Profile

PATCH

/api/users/{userId}/status?active={true/false}


Query Parameter

active – Set true to activate, false to deactivate

Response (200 OK)

{
  "success": true,
  "message": "User profile activated successfully",
  "data": {
    "userId": 2,
    "username": "alice_smith",
    "active": true
  }
}

 Testing

All endpoints tested using Postman

Correct HTTP status codes returned (200, 201, 204, 404)

Query parameters for search and status updates work as expected

 Status

Completed and verified