# 📚 Bookstore API – Spring Boot + JPA

REST API for managing books, authors, publishers and reviews using **Spring Boot**, **Spring Data JPA** and **PostgreSQL**.

---

## 🚀 Technologies

- Java 21+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Jakarta Validation

---

## 📂 Project Structure
```text
src/main/java/com/bookstore/jpa  
├── controller  
├── entity
│        └── dto
├── mapper  
├── repository  
└── service
```
---

## ⚙️ Configuration

Create your database in PostgreSQL:

```sql
CREATE DATABASE bookstore-jpa;
```
Configure your application.yaml:

    spring:
    datasource:
        url: jdbc:postgresql://localhost:5432/bookstore-jpa
        username: YOUR_USER
        password: YOUR_PASSWORD
    jpa:
        hibernate:
            ddl-auto: update
        show-sql: true
---

▶️ Running the project

Using Maven Wrapper:

    ./mvnw spring-boot:run

Or Maven:

    mvn spring-boot:run

---

📌 API Endpoints

✍️ Authors

| Method | Endpoint                  | Description      |
| ------ | ------------------------- | ---------------- |
| POST   | `/bookstore/authors`      | Create author    |
| GET    | `/bookstore/authors/{id}` | Get author by id |
| DELETE | `/bookstore/authors/{id}` | Delete author    |

🏢 Publishers

| Method | Endpoint                     | Description         |
| ------ | ---------------------------- | ------------------- |
| POST   | `/bookstore/publishers`      | Create publisher    |
| GET    | `/bookstore/publishers/{id}` | Get publisher by id |
| DELETE | `/bookstore/publishers/{id}` | Delete publisher    |

📚 Books

| Method | Endpoint                | Description    |
| ------ | ----------------------- | -------------- |
| POST   | `/bookstore/books`      | Create book    |
| GET    | `/bookstore/books/{id}` | Get book by id |
| DELETE | `/bookstore/books/{id}` | Delete book    |

---

🧾 Request Example – Create Book

    {
    "title": "Clean Code",
    "publisher": "Prentice Hall",
    "authors": ["Robert C. Martin"],
    "reviewComment": "Excellent book for software engineers"
    }

---

🧾 Response Example – Book

    {
    "id": 1,
    "title": "Clean Code",
    "publisher": "Prentice Hall",
    "authors": ["Robert C. Martin"],
    "reviewComment": "Excellent book for software engineers"
    }

✅ Features

* DTO pattern (Request / Response)
* Entity relationships:
* Many-to-Many → Book ↔ Authors
* Many-to-One → Book → Publisher
* One-to-One → Book → Review
* Validation with @Valid
* Existence checks before persistence
* Transactional service layer
* Proper HTTP status codes

---

🛠️ Future Improvements

* Flyway for database migrations

* Docker support

* Global exception handler (@ControllerAdvice)

* Pagination and sorting

* Swagger / OpenAPI documentation

* Unit and integration tests
