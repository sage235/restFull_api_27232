Name: Mr ASDODJI Le Sage

Course: Web Technologies / Spring Boot
Assignment: RESTful API Implementation

Question 4 – E-Commerce REST API
Description

This Spring Boot REST API manages products in a simple e-commerce system.
It supports product management with CRUD operations, searching, filtering by category, brand, price range, and stock availability.
The application uses an in-memory list to store product data.

How to Run the Application
Prerequisites

Java 17 or higher

Maven

Spring Boot

Run Commands
mvn clean install
mvn spring-boot:run


The application runs on:

http://localhost:8080

Base URL
/api/products

API Endpoints
1️. Get All Products (with optional pagination)

Method: GET

/api/products?page={page}&limit={limit}


Response (200 OK)

[
  {
    "productId": 1,
    "name": "iPhone 14",
    "description": "Apple smartphone",
    "price": 999.99,
    "category": "Electronics",
    "stockQuantity": 10,
    "brand": "Apple"
  },
  {
    "productId": 2,
    "name": "Galaxy S23",
    "description": "Samsung smartphone",
    "price": 899.99,
    "category": "Electronics",
    "stockQuantity": 5,
    "brand": "Samsung"
  }
]

2️. Get Product by ID

Method: GET

/api/products/{productId}


Example

/api/products/3


Response (200 OK)

{
  "productId": 3,
  "name": "MacBook Pro",
  "description": "Apple laptop",
  "price": 1999.99,
  "category": "Computers",
  "stockQuantity": 3,
  "brand": "Apple"
}

3️. Get Products by Category

Method: GET

/api/products/category/{category}


Example

/api/products/category/Electronics


Response (200 OK)

[
  {
    "productId": 1,
    "name": "iPhone 14",
    "description": "Apple smartphone",
    "price": 999.99,
    "category": "Electronics",
    "stockQuantity": 10,
    "brand": "Apple"
  },
  {
    "productId": 2,
    "name": "Galaxy S23",
    "description": "Samsung smartphone",
    "price": 899.99,
    "category": "Electronics",
    "stockQuantity": 5,
    "brand": "Samsung"
  },
  {
    "productId": 9,
    "name": "Samsung TV",
    "description": "4K Smart TV",
    "price": 799.99,
    "category": "Electronics",
    "stockQuantity": 4,
    "brand": "Samsung"
  }
]

4️. Get Products by Brand

Method: GET

/api/products/brand/{brand}


Example

/api/products/brand/Apple


Response (200 OK)

[
  {
    "productId": 1,
    "name": "iPhone 14",
    "description": "Apple smartphone",
    "price": 999.99,
    "category": "Electronics",
    "stockQuantity": 10,
    "brand": "Apple"
  },
  {
    "productId": 3,
    "name": "MacBook Pro",
    "description": "Apple laptop",
    "price": 1999.99,
    "category": "Computers",
    "stockQuantity": 3,
    "brand": "Apple"
  },
  {
    "productId": 10,
    "name": "Apple Watch",
    "description": "Smart watch",
    "price": 399.99,
    "category": "Wearables",
    "stockQuantity": 6,
    "brand": "Apple"
  }
]

5️. Search Products by Keyword

Method: GET

/api/products/search?keyword=laptop


Response (200 OK)

[
  {
    "productId": 3,
    "name": "MacBook Pro",
    "description": "Apple laptop",
    "price": 1999.99,
    "category": "Computers",
    "stockQuantity": 3,
    "brand": "Apple"
  },
  {
    "productId": 4,
    "name": "Dell XPS",
    "description": "Dell laptop",
    "price": 1499.99,
    "category": "Computers",
    "stockQuantity": 0,
    "brand": "Dell"
  }
]

6️. Get Products by Price Range

Method: GET

/api/products/price-range?min=100&max=500


Response (200 OK)

[
  {
    "productId": 5,
    "name": "Sony Headphones",
    "price": 299.99,
    "stockQuantity": 15
  },
  {
    "productId": 10,
    "name": "Apple Watch",
    "price": 399.99,
    "stockQuantity": 6
  }
]

7️. Get Products In Stock

Method: GET

/api/products/in-stock


Response (200 OK)

[
  {
    "productId": 1,
    "name": "iPhone 14",
    "stockQuantity": 10
  },
  {
    "productId": 5,
    "name": "Sony Headphones",
    "stockQuantity": 15
  }
]

8️. Add New Product

Method: POST

/api/products


Request Body

{
  "name": "Tablet",
  "description": "Android tablet",
  "price": 499.99,
  "category": "Electronics",
  "stockQuantity": 7,
  "brand": "Samsung"
}


Response (201 Created)

{
  "productId": 11,
  "name": "Tablet",
  "description": "Android tablet",
  "price": 499.99,
  "category": "Electronics",
  "stockQuantity": 7,
  "brand": "Samsung"
}

9️. Update Product Details

Method: PUT

/api/products/{productId}


Example

/api/products/7


Request Body

{
  "name": "Nike Shoes Pro",
  "description": "Professional running shoes",
  "price": 149.99,
  "category": "Fashion",
  "stockQuantity": 6,
  "brand": "Nike"
}


Response (200 OK)

{
  "productId": 7,
  "name": "Nike Shoes Pro",
  "description": "Professional running shoes",
  "price": 149.99,
  "category": "Fashion",
  "stockQuantity": 6,
  "brand": "Nike"
}

10. Update Stock Quantity

Method: PATCH

/api/products/{productId}/stock?quantity=12


Response (200 OK)

{
  "productId": 6,
  "name": "Logitech Mouse",
  "stockQuantity": 12
}

1️1️. Delete Product

Method: DELETE

/api/products/{productId}


Example

/api/products/8


Response (204 No Content)

Testing

All endpoints tested using Postman

Edge cases handled (out-of-stock products, invalid IDs)

Correct HTTP status codes returned

Status

 Completed and verified
