### README.md

```md
# Ticket Management System - Java Spring Boot Backend

## Overview
This is a **Spring Boot** application that demonstrates basic **CRUD (Create, Read, Update, Delete)** operations for managing tickets. It provides a set of RESTful APIs to create, update, retrieve, and delete tickets, all stored in-memory without the need for a database.

## Technologies Used
- **Java 22**
- **Spring Boot 3.2.x**
- **Maven**
- **Spring Web** for building REST APIs
- **JUnit 5** for unit testing

## Setup and Run

### Run the application:

```bash
mvn spring-boot:run
```

The backend will run on `http://localhost:8080`.

### API Endpoints

| HTTP Method | Endpoint           | Description                |
|-------------|--------------------|----------------------------|
| **POST**    | `/tickets`          | Create a new ticket         |
| **GET**     | `/tickets`          | Get all tickets             |
| **GET**     | `/tickets/{id}`     | Get a specific ticket by ID |
| **PUT**     | `/tickets/{id}`     | Update an existing ticket   |
| **DELETE**  | `/tickets/{id}`     | Delete a ticket by ID       |

### Example Requests:

#### Create a Ticket (POST):
```bash
curl -X POST http://localhost:8080/tickets \
     -H "Content-Type: application/json" \
     -d '{"description": "Ticket 1", "status": "Open"}'
```

#### Get All Tickets (GET):
```bash
curl http://localhost:8080/tickets
```

#### Get a Specific Ticket by ID (GET):
```bash
curl http://localhost:8080/tickets/1
```

#### Update a Ticket (PUT):
```bash
curl -X PUT http://localhost:8080/tickets/1 \
     -H "Content-Type: application/json" \
     -d '{"description": "Updated Ticket", "status": "Closed"}'
```

#### Delete a Ticket (DELETE):
```bash
curl -X DELETE http://localhost:8080/tickets/1
```

### Running Tests

Run the unit tests using **Maven**:

```bash
mvn test
```

### License
This project is licensed under the MIT Licens