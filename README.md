# Company Structure - Spring Boot REST API

This project is a Spring Boot-based RESTful API designed to manage a company's internal structure. It allows full CRUD operations for managing departments and employees across various roles and salary levels.

---

## Features

- ✅ RESTful APIs for Companies, Departments, and Employees (full CRUD operations)
- ✅ DTO-based request and response models
- ✅ Inheritance in entity classes (e.g., Developer, DataScientist extend Employee)
- ✅ Authentication and Authorization using starter dependency (spring-boot-starter-security)
- ✅ PostgreSQL with Spring Data JPA
- ✅ Global Exception Handling
- ✅ Enum support for employee level (ENTRY, MANAGER, SENIOR)
- ✅ Unit testing using JUnit and Mockito
- ✅ Database schema setup via `CreateTable.sql` script
- ✅ Logging(in presentation layer) and business logic in Service layer


---

## 🛠 Tech Stack

- **JDK21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **PostgreSQL**
- **Gradle**(build automation tool)
  
---

## 🗃️ Database Schema (PostgreSQL)

- Departments and Employees are related via `@OneToMany`
- Each employee record includes:
  - `id`, `name`, `role`, `level`, `salary`, `department_id`

---

## 📂 Project Structure

├── src/
│ ├── main/java/com/example/company_structure/
│ │ ├── controller/ ← API endpoints
│ │ ├── dto/ ← DTOs for request/response
│ │ ├── exception/ ← Global exception handling
│ │ ├── model/ ← Entities and enums (like Level)
│ │ ├── repository/ ← JPA repositories
│ │ └── service/ ← Business logic and unit-testable methods
│ └── resources/
│ ├── application.properties
│ └── schema.sql (optional)
│
├── Postgres_db/
│ └── CreateTable.sql ← PostgreSQL table schema
│
├── .gitignore
├── build.gradle
├── README.md
└── test/ ← JUnit + Mockito test classes

