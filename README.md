
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

question5-task-api/README.md
# Question 5 – Task Management REST API

##  Description
This Spring Boot REST API manages tasks in a simple task management system.  
It supports CRUD operations, filtering by status and priority, and marking tasks as completed.

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


The application runs on:

http://localhost:8080

 Base URL
/api/tasks

 API Endpoints
1️. Get All Tasks

GET

/api/tasks


Response (200 OK)

[
  {
    "taskId": 1,
    "title": "Complete Assignment",
    "description": "Finish the Spring Boot project",
    "priority": "HIGH",
    "completed": false
  }
]

2️. Get Task by ID

GET

/api/tasks/{taskId}


Response (200 OK)

{
  "taskId": 1,
  "title": "Complete Assignment",
  "description": "Finish the Spring Boot project",
  "priority": "HIGH",
  "completed": false
}

3️. Get Tasks by Completion Status

GET

/api/tasks/status?completed={true/false}


Query Parameter

completed – Filter tasks by completion status

Response (200 OK)

[
  {
    "taskId": 2,
    "title": "Read Book",
    "description": "Read Clean Code",
    "priority": "MEDIUM",
    "completed": true
  }
]

4️. Get Tasks by Priority

GET

/api/tasks/priority/{priority}


Path Parameter

priority – Task priority (LOW, MEDIUM, HIGH)

Response (200 OK)

[
  {
    "taskId": 3,
    "title": "Submit Report",
    "description": "Send the monthly report to manager",
    "priority": "HIGH",
    "completed": false
  }
]

5️. Create New Task

POST

/api/tasks


Request Body

{
  "title": "Buy Groceries",
  "description": "Milk, Eggs, Bread",
  "priority": "MEDIUM"
}


Response (201 Created)

{
  "taskId": 4,
  "title": "Buy Groceries",
  "description": "Milk, Eggs, Bread",
  "priority": "MEDIUM",
  "completed": false
}

6️. Update Task

PUT

/api/tasks/{taskId}


Request Body

{
  "title": "Buy Groceries and Fruits",
  "description": "Milk, Eggs, Bread, Apples",
  "priority": "HIGH",
  "completed": false
}


Response (200 OK)

{
  "taskId": 4,
  "title": "Buy Groceries and Fruits",
  "description": "Milk, Eggs, Bread, Apples",
  "priority": "HIGH",
  "completed": false
}

7️. Mark Task as Completed

PATCH

/api/tasks/{taskId}/complete


Response (200 OK)

{
  "taskId": 4,
  "title": "Buy Groceries and Fruits",
  "completed": true
}

8️. Delete Task

DELETE

/api/tasks/{taskId}


Response (204 No Content)

 Testing

Verified all endpoints using Postman

Correct HTTP status codes returned (200, 201, 204, 404)

Filters and PATCH updates behave as expected

 Status

Completed and verified