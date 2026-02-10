
Name: Mr ASDODJI Le Sage
Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

# Question 4 – E-Commerce REST API

##  Description
This Spring Boot REST API manages products in a simple e-commerce system.  
It supports product management with CRUD operations, searching, filtering, and stock management.

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
/api/products
 API Endpoints
1️. Get All Products (with optional pagination)
GET

/api/products?page={page}&limit={limit}
Query Parameters

page (optional) – Page number (default: 1)

limit (optional) – Number of items per page (default: all)

Response (200 OK)

[
  {
    "productId": 1,
    "name": "Laptop",
    "category": "Electronics",
    "brand": "Dell",
    "description": "Gaming Laptop",
    "price": 1200.0,
    "stockQuantity": 10
  }
]
2️. Get Product by ID
GET

/api/products/{productId}
Response (200 OK)

{
  "productId": 1,
  "name": "Laptop",
  "category": "Electronics",
  "brand": "Dell",
  "description": "Gaming Laptop",
  "price": 1200.0,
  "stockQuantity": 10
}
3️. Get Products by Category
GET

/api/products/category/{category}
Response (200 OK)

[
  {
    "productId": 2,
    "name": "Smartphone",
    "category": "Electronics",
    "brand": "Samsung",
    "description": "Latest model",
    "price": 900.0,
    "stockQuantity": 15
  }
]
4️. Get Products by Brand
GET

/api/products/brand/{brand}
Response (200 OK)

[
  {
    "productId": 3,
    "name": "Mouse",
    "category": "Accessories",
    "brand": "Logitech",
    "description": "Wireless mouse",
    "price": 25.0,
    "stockQuantity": 50
  }
]
5️. Search Products by Keyword
GET

/api/products/search?keyword={keyword}
Response (200 OK)

[
  {
    "productId": 1,
    "name": "Laptop",
    "description": "Gaming Laptop",
    "category": "Electronics",
    "brand": "Dell",
    "price": 1200.0,
    "stockQuantity": 10
  }
]
6️. Get Products by Price Range
GET

/api/products/price-range?min={min}&max={max}
Response (200 OK)

[
  {
    "productId": 4,
    "name": "Keyboard",
    "price": 50.0,
    "stockQuantity": 30
  }
]
7️. Get Products in Stock
GET

/api/products/in-stock
Response (200 OK)

[
  {
    "productId": 1,
    "name": "Laptop",
    "stockQuantity": 10
  }
]
8️. Add New Product
POST

/api/products
Request Body

{
  "name": "Headphones",
  "category": "Accessories",
  "brand": "Sony",
  "description": "Noise-cancelling",
  "price": 200.0,
  "stockQuantity": 25
}
Response (201 Created)

{
  "productId": 5,
  "name": "Headphones",
  "category": "Accessories",
  "brand": "Sony",
  "description": "Noise-cancelling",
  "price": 200.0,
  "stockQuantity": 25
}
9️. Update Product Details
PUT

/api/products/{productId}
Request Body

{
  "name": "Headphones Pro",
  "category": "Accessories",
  "brand": "Sony",
  "description": "Noise-cancelling Pro",
  "price": 250.0,
  "stockQuantity": 20
}
Response (200 OK)

{
  "productId": 5,
  "name": "Headphones Pro",
  "category": "Accessories",
  "brand": "Sony",
  "description": "Noise-cancelling Pro",
  "price": 250.0,
  "stockQuantity": 20
}
10. Update Stock Quantity
PATCH

/api/products/{productId}/stock?quantity={quantity}
Response (200 OK)

{
  "productId": 5,
  "name": "Headphones Pro",
  "stockQuantity": 30
}
1️1️. Delete Product
DELETE

/api/products/{productId}
Response (204 No Content)

 Testing
Verified all endpoints using Postman

Handles edge cases (invalid IDs, empty results)

Correct HTTP status codes returned

Status
Completed and verified