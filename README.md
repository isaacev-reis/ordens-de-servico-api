# 🛠️ Service Orders API

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen?logo=spring)
![H2 Database](https://img.shields.io/badge/H2%20DB-informational?logo=h2database)
![Lombok](https://img.shields.io/badge/Lombok-EF2F8F?logo=lombok)
![UUID](https://img.shields.io/badge/UUID-secure-orange)

A robust REST API for **service order management**, built with **Spring Boot**.  
It uses a **state machine** to ensure the workflow of service orders is strictly followed.

---

## 🚀 Tech Stack

- **Java 21**  
- **Spring Boot 3**  
- **Spring Data JPA** – for data persistence  
- **Lombok** – reduces boilerplate (Getters/Setters)  
- **UUID** – unique and universal identifiers for security  
- **H2 Database** – in-memory data storage

---

## 📋 Business Rules

The API manages the lifecycle of an order through the following **states**:

| State          | Description                                   |
|---------------|-----------------------------------------------|
| **OPEN**        | Order created and waiting to start          |
| **IN_PROGRESS** | The service is being executed               |
| **COMPLETED**   | Service successfully completed             |
| **CANCELED**    | Order canceled (only if not completed)     |

---

## 🛣️ Main Endpoints

```bash
POST    /orders             # Create a new order (UUID + OPEN)
GET     /orders             # List all service orders
GET     /orders/{id}        # Get service order by UUID
PATCH   /orders/start/{id}  # Change status to IN_PROGRESS
PATCH   /orders/finish/{id} # Change status to COMPLETED
PATCH   /orders/cancel/{id} # Change status to CANCELED
