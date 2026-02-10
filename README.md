Name: Mr ASDODJI Le Sage

Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 5 – Task Management REST API
Description

This Spring Boot REST API manages tasks in a simple task management system.
It supports CRUD operations, filtering by status and priority, and marking tasks as completed.
The application uses an in-memory list to store tasks.

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
/api/tasks

API Endpoints
1️. Get All Tasks

Method: GET

/api/tasks


Response (200 OK)

[
  {
    "taskId": 1,
    "title": "Finish Assignment",
    "description": "Complete REST API project",
    "priority": "HIGH",
    "completed": false,
    "dueDate": "2026-02-10"
  },
  {
    "taskId": 2,
    "title": "Study Spring Boot",
    "description": "Revise controllers",
    "priority": "MEDIUM",
    "completed": true,
    "dueDate": "2026-02-08"
  },
  {
    "taskId": 3,
    "title": "Buy groceries",
    "description": "Milk and bread",
    "priority": "LOW",
    "completed": false,
    "dueDate": "2026-02-09"
  }
]

2️. Get Task by ID

Method: GET

/api/tasks/{taskId}


Example

/api/tasks/1


Response (200 OK)

{
  "taskId": 1,
  "title": "Finish Assignment",
  "description": "Complete REST API project",
  "priority": "HIGH",
  "completed": false,
  "dueDate": "2026-02-10"
}

3️. Get Tasks by Completion Status

Method: GET

/api/tasks/status?completed=true


Query Parameter:
completed – Filter tasks by completion status

Response (200 OK)

[
  {
    "taskId": 2,
    "title": "Study Spring Boot",
    "description": "Revise controllers",
    "priority": "MEDIUM",
    "completed": true,
    "dueDate": "2026-02-08"
  }
]

4️. Get Tasks by Priority

Method: GET

/api/tasks/priority/{priority}


Path Parameter:
priority – Task priority (LOW, MEDIUM, HIGH)

Example

/api/tasks/priority/HIGH


Response (200 OK)

[
  {
    "taskId": 1,
    "title": "Finish Assignment",
    "description": "Complete REST API project",
    "priority": "HIGH",
    "completed": false,
    "dueDate": "2026-02-10"
  }
]

5️. Create New Task

Method: POST

/api/tasks


Request Body

{
  "title": "New Task",
  "description": "Task description",
  "priority": "MEDIUM",
  "dueDate": "2026-02-11"
}


Response (201 Created)

{
  "taskId": 4,
  "title": "New Task",
  "description": "Task description",
  "priority": "MEDIUM",
  "completed": false,
  "dueDate": "2026-02-11"
}

6️. Update Task

Method: PUT

/api/tasks/{taskId}


Request Body

{
  "title": "Buy groceries and fruits",
  "description": "Milk and bread, add apples",
  "priority": "HIGH",
  "completed": false,
  "dueDate": "2026-02-09"
}


Response (200 OK)

{
  "taskId": 3,
  "title": "Buy groceries and fruits",
  "description": "Milk and bread, add apples",
  "priority": "HIGH",
  "completed": false,
  "dueDate": "2026-02-09"
}

7️. Mark Task as Completed

Method: PATCH

/api/tasks/{taskId}/complete


Response (200 OK)

{
  "taskId": 3,
  "title": "Buy groceries and fruits",
  "completed": true
}

8️. Delete Task

Method: DELETE

/api/tasks/{taskId}


Example

/api/tasks/2


Response (204 No Content)

Testing

Verified all endpoints using Postman

Filters and PATCH updates behave correctly

Correct HTTP status codes returned (200, 201, 204)

Status

Completed and verified
