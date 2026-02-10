
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

# Question 2 – Student REST API

##  Description
This Spring Boot REST API manages student data.  
It allows CRUD operations, search by name, and filtering by grade or age.

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
/api/students

 API Endpoints

1️. Get All Students

GET

http://localhost:8080/api/students


Response (200 OK)

[
  {
    "studentId": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 21,
    "grade": "A"
  }
]

2️. Get Student by ID

GET

http://localhost:8080/api/students/{studentId}


Example

http://localhost:8080/api/students/1


Response (200 OK)

{
  "studentId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "age": 21,
  "grade": "A"
}

3️. Search Students by Name

GET

http://localhost:8080/api/students/search?name=john


Response (200 OK)

[
  {
    "studentId": 1,
    "firstName": "John",
    "lastName": "Doe",
    "age": 21,
    "grade": "A"
  }
]

4️. Add a New Student

POST

http://localhost:8080/api/students


Request Body

{
  "studentId": 2,
  "firstName": "Jane",
  "lastName": "Smith",
  "age": 22,
  "grade": "B"
}


Response (201 Created)

{
  "studentId": 2,
  "firstName": "Jane",
  "lastName": "Smith",
  "age": 22,
  "grade": "B"
}

5️. Update a Student

PUT

http://localhost:8080/api/students/{studentId}


Request Body

{
  "firstName": "Jane",
  "lastName": "Doe",
  "age": 23,
  "grade": "A"
}


Response (200 OK)

{
  "studentId": 2,
  "firstName": "Jane",
  "lastName": "Doe",
  "age": 23,
  "grade": "A"
}

6️. Delete a Student

DELETE

http://localhost:8080/api/students/{studentId}


Response (204 No Content)

 Testing

Tested with Postman

Verified GET endpoints in browser

Correct HTTP status codes returned (200, 201, 204)

 Status

 Completed and verified