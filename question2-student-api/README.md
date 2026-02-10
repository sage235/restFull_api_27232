Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 2 – Student Management REST API
 Description

This project is a Spring Boot REST API designed to manage student information.
It allows clients to register students, retrieve all students, get a student by ID, filter students by major, filter students based on GPA, and update student information.

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
    "firstName": "ASDODJI",
    "lastName": "Le Sage",
    "email": "asdodji@auca.ac.rw",
    "major": "Software Engineering",
    "gpa": 4.5
  },
  {
    "studentId": 2,
    "firstName": "NADJILEM",
    "lastName": "Oscar",
    "email": "nadjilem@auca.ac.rw",
    "major": "Software Engineering",
    "gpa": 4.8
  }
]

2️. Get Student by ID

Method: GET

http://localhost:8080/api/students/{studentId}


Example

http://localhost:8080/api/students/3


Response (200 OK)

{
  "studentId": 3,
  "firstName": "SADE",
  "lastName": "George",
  "email": "sade@auca.ac.rw",
  "major": "Software Engineering",
  "gpa": 4.9
}

3️. Get Students by Major

Method: GET

http://localhost:8080/api/students/major/{major}


Example

http://localhost:8080/api/students/major/Business


Response (200 OK)

[
  {
    "studentId": 4,
    "firstName": "Saint",
    "lastName": "Moses",
    "email": "saint@auca.ac.rw",
    "major": "Business",
    "gpa": 2.7
  },
  {
    "studentId": 5,
    "firstName": "Pablo Emilio",
    "lastName": "Escobar Gaviria",
    "email": "pablo@auca.ac.rw",
    "major": "Business",
    "gpa": 3.2
  }
]

4️. Filter Students by Minimum GPA

Method: GET

http://localhost:8080/api/students/filter?gpa=4.5


Response (200 OK)

[
  {
    "studentId": 1,
    "firstName": "ASDODJI",
    "lastName": "Le Sage",
    "email": "asdodji@auca.ac.rw",
    "major": "Software Engineering",
    "gpa": 4.5
  },
  {
    "studentId": 2,
    "firstName": "NADJILEM",
    "lastName": "Oscar",
    "email": "nadjilem@auca.ac.rw",
    "major": "Software Engineering",
    "gpa": 4.8
  },
  {
    "studentId": 3,
    "firstName": "SADE",
    "lastName": "George",
    "email": "sade@auca.ac.rw",
    "major": "Software Engineering",
    "gpa": 4.9
  }
]

5️. Register a New Student

Method: POST

http://localhost:8080/api/students


Request Body

{
  "studentId": 6,
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane@auca.ac.rw",
  "major": "Software Engineering",
  "gpa": 3.6
}


Response (201 Created)

{
  "studentId": 6,
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane@auca.ac.rw",
  "major": "Software Engineering",
  "gpa": 3.6
}

6️. Update Student Information

Method: PUT

http://localhost:8080/api/students/{studentId}


Example

http://localhost:8080/api/students/5


Request Body

{
  "firstName": "Pablo Emilio",
  "lastName": "Escobar Gaviria",
  "email": "pablo@auca.ac.rw",
  "major": "Business",
  "gpa": 3.5
}


Response (200 OK)

{
  "studentId": 5,
  "firstName": "Pablo Emilio",
  "lastName": "Escobar Gaviria",
  "email": "pablo@auca.ac.rw",
  "major": "Business",
  "gpa": 3.5
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
