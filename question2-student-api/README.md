Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 2 – Student Management REST API
Description

This project is a Spring Boot REST API designed to manage student information.
It allows clients to register students, retrieve all students, get a student by ID, filter students by major, and filter students based on GPA.
The application uses an in-memory list to store student data.

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
/api/students

API Endpoints
1️. Get All Students

Method: GET

http://localhost:8080/api/students


Response (200 OK)

[
  {
    "studentId": 1,
    "name": "John Doe",
    "major": "Computer Science",
    "gpa": 3.5
  }
]

2️. Get Student by ID

Method: GET

http://localhost:8080/api/students/{studentId}


Example

http://localhost:8080/api/students/1


Response (200 OK)

{
  "studentId": 1,
  "name": "John Doe",
  "major": "Computer Science",
  "gpa": 3.5
}

3️. Get Students by Major

Method: GET

http://localhost:8080/api/students/major/{major}


Example

http://localhost:8080/api/students/major/Computer Science


Response (200 OK)

[
  {
    "studentId": 1,
    "name": "John Doe",
    "major": "Computer Science",
    "gpa": 3.5
  }
]

4️. Filter Students by Minimum GPA

Method: GET

http://localhost:8080/api/students/filter?gpa=3.0


Response (200 OK)

[
  {
    "studentId": 1,
    "name": "John Doe",
    "major": "Computer Science",
    "gpa": 3.5
  }
]

5️. Register a New Student

Method: POST

http://localhost:8080/api/students


Request Body

{
  "studentId": 2,
  "name": "Alice Smith",
  "major": "Information Technology",
  "gpa": 3.8
}


Response (201 Created)

{
  "studentId": 2,
  "name": "Alice Smith",
  "major": "Information Technology",
  "gpa": 3.8
}

6️. Update Student Information

Method: PUT

http://localhost:8080/api/students/{studentId}


Example

http://localhost:8080/api/students/2


Request Body

{
  "name": "Alice Smith",
  "major": "Software Engineering",
  "gpa": 3.9
}


Response (200 OK)

{
  "studentId": 2,
  "name": "Alice Smith",
  "major": "Software Engineering",
  "gpa": 3.9
}

Testing

Tested using Postman

Endpoints validated with different parameters

Correct HTTP status codes returned:

200 OK

201 Created

Screenshots or Postman results are included in the Testing/ folder.

Status

 Completed and verified
