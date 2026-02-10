
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation


# Question 3 – Restaurant REST API

##  Description
This Spring Boot REST API manages restaurant menu items and orders.  
It allows CRUD operations for dishes, search by name or category, and filtering by price.

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
/api/restaurants

 API Endpoints
1️. Get All Menu Items

GET

http://localhost:8080/api/restaurants/menu


Response (200 OK)

[
  {
    "itemId": 1,
    "name": "Margherita Pizza",
    "category": "Pizza",
    "price": 8.5,
    "available": true
  }
]

2️. Get Menu Item by ID

GET

http://localhost:8080/api/restaurants/menu/{itemId}


Example

http://localhost:8080/api/restaurants/menu/1


Response (200 OK)

{
  "itemId": 1,
  "name": "Margherita Pizza",
  "category": "Pizza",
  "price": 8.5,
  "available": true
}

3️. Search Menu Items by Name

GET

http://localhost:8080/api/restaurants/menu/search?name=pizza


Response (200 OK)

[
  {
    "itemId": 1,
    "name": "Margherita Pizza",
    "category": "Pizza",
    "price": 8.5,
    "available": true
  }
]

4️. Get Items by Category

GET

http://localhost:8080/api/restaurants/menu/category/{category}


Example

http://localhost:8080/api/restaurants/menu/category/Pizza


Response (200 OK)

[
  {
    "itemId": 1,
    "name": "Margherita Pizza",
    "category": "Pizza",
    "price": 8.5,
    "available": true
  }
]

6. Add a New Menu Item

POST

http://localhost:8080/api/restaurants/menu


Request Body

{
  "itemId": 2,
  "name": "Caesar Salad",
  "category": "Salad",
  "price": 6.0,
  "available": true
}


Response (201 Created)

{
  "itemId": 2,
  "name": "Caesar Salad",
  "category": "Salad",
  "price": 6.0,
  "available": true
}

7️. Toggle Menu Item Availability

Method: PUT

http://localhost:8080/api/menu/{id}/availability


Example

http://localhost:8080/api/menu/2/availability

Body (JSON)
{
  "id": 2,
  "name": "Chicken Pizza",
  "category": "Fast Food",
  "price": 8000,
  "available": true
}

Response (200 OK)

{
  "id": 2,
  "name": "Chicken Pizza",
  "category": "Fast Food",
  "price": 8000,
  "available": false
}


8. Delete a Menu Item

DELETE

http://localhost:8080/api/restaurants/menu/{itemId}


Response (204 No Content)

 Testing

Tested all endpoints in Postman

GET endpoints verified in browser

Correct HTTP status codes returned (200, 201, 204)

 Status

 Completed and verified
