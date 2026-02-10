Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 3 – Restaurant REST API
Description

This Spring Boot REST API manages restaurant menu items.
It supports CRUD operations, searching menu items by name, filtering by category, and checking availability.

All data is stored in an in-memory list for demonstration purposes.

How to Run the Application
Prerequisites

Java 17+

Maven

Spring Boot

Run Commands
mvn clean install
mvn spring-boot:run


The application will start at:

http://localhost:8080

Base URL
/api/menu

 API Endpoints
1️.Get All Menu Items

GET

http://localhost:8080/api/menu


Response (200 OK)

[
  {
    "id": 1,
    "name": "Spring Rolls",
    "description": "Crispy vegetable spring rolls served with sweet chili sauce",
    "price": 5.99,
    "category": "Appetizer",
    "available": true
  }
]

2️. Get Menu Item by ID

GET

http://localhost:8080/api/menu/{id}


Example

http://localhost:8080/api/menu/3


Response (200 OK)

{
  "id": 3,
  "name": "Grilled Chicken",
  "description": "Grilled chicken breast seasoned with special spices",
  "price": 12.99,
  "category": "Main Course",
  "available": true
}

3️. Get Items by Category

GET

http://localhost:8080/api/menu/category/{category}


Example

http://localhost:8080/api/menu/category/Dessert


Response (200 OK)

[
  {
    "id": 5,
    "name": "Chocolate Cake",
    "description": "Rich and moist chocolate cake topped with chocolate sauce",
    "price": 6.99,
    "category": "Dessert",
    "available": true
  },
  {
    "id": 6,
    "name": "Vanilla Ice Cream",
    "description": "Classic vanilla ice cream scoop",
    "price": 3.99,
    "category": "Dessert",
    "available": true
  }
]

4️. Get Available Menu Items

GET

http://localhost:8080/api/menu/available?available=true


Response (200 OK)

[
  {
    "id": 7,
    "name": "Orange Juice",
    "description": "Freshly squeezed orange juice",
    "price": 2.99,
    "category": "Beverage",
    "available": true
  }
]

5️. Search Menu Items by Name

GET

http://localhost:8080/api/menu/search?name=coffee


Response (200 OK)

[
  {
    "id": 8,
    "name": "Hot Coffee",
    "description": "Freshly brewed hot coffee",
    "price": 1.99,
    "category": "Beverage",
    "available": false
  }
]

6️. Add a New Menu Item

POST

http://localhost:8080/api/menu


Request Body

{
  "id": 9,
  "name": "Fried Rice",
  "description": "Rice stir-fried with vegetables and eggs",
  "price": 7.99,
  "category": "Main Course",
  "available": true
}


Response (201 Created)

{
  "id": 9,
  "name": "Fried Rice",
  "description": "Rice stir-fried with vegetables and eggs",
  "price": 7.99,
  "category": "Main Course",
  "available": true
}

7️. Toggle Item Availability

PUT

http://localhost:8080/api/menu/{id}/availability


Example

http://localhost:8080/api/menu/4/availability


Response (200 OK)

{
  "message": "Item availability updated successfully"
}

8️. Delete Menu Item

DELETE

http://localhost:8080/api/menu/{id}


Example

http://localhost:8080/api/menu/8


Response (204 No Content)

 Testing

All endpoints tested using Postman

GET endpoints verified using a web browser

Correct HTTP status codes returned: 200, 201, 204

 Status

Completed and verified
