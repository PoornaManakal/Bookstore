# 📚 Bookstore RESTful API – Java JAX-RS

## 🚀 Introduction

This is a RESTful API for a Bookstore application developed using **Java with JAX-RS (`javax.ws.rs`)**. The API allows managing books, authors, customers, shopping carts, and orders. It follows RESTful principles and uses **in-memory storage** (no database) for data management.

---

## ⚙️ Setup Instructions

###  🔗 Requirements
- **Java 17** or higher  
- **NetBeans IDE** (recommended)  
- **Postman** for API testing  

###  ✅ Running the Project
1. Open the project folder in NetBeans.  
2. Right-click the project → **Run**.  
3. Test the API using Postman at:  http://localhost:8080/BookstoreAPI/webresources

---

## API Overview

| Resource    | Endpoint                                  |
|-------------|--------------------------------------------|
| **Books**   | `/books`                                  |
| **Authors** | `/authors`                                |
| **Customers** | `/customers`                            |
| **Cart**    | `/customers/{customerId}/cart`            |
| **Orders**  | `/customers/{customerId}/orders`          |

Supports standard HTTP methods:  
**GET, POST, PUT, DELETE** for managing resources.

---


## 📂 Technologies Used

- Java with JAX-RS (`javax.ws.rs`)  
- JSON for request/response  
- Postman for testing  
- In-memory storage (ArrayList, HashMap)

