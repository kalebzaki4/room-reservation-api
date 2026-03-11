# 🚀 SyncSpace API

> A professional-grade Room Reservation System built with Java 21 and Spring Boot 3. Optimized for concurrency, security, and scalability.

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue?style=for-the-badge&logo=docker)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

**SyncSpace** is a robust REST API designed to handle corporate meeting room bookings. It goes beyond a simple CRUD by implementing advanced backend concepts like **Optimistic Locking** for concurrency and **Stateless JWT Authentication**.

## ✨ Features

- ⚡ **Spring Boot 3.2** — Built using the latest features of the Spring ecosystem.
- ⛑ **Optimistic Locking** — Prevents double-booking using JPA versioning (`@Version`).
- 🔐 **Stateless Security** — Secure endpoints with Spring Security and JWT.
- 🗃 **MySQL 8.0** — High-performance relational data management.
- 🐳 **Docker Ready** — Fully containerized environment (App + DB) for easy deployment.
- 📏 **Clean Architecture** — Clearly separated layers for Controllers, Services, and Repositories.
- 🛡 **Data Validation** — Strict request validation using Bean Validation (Hibernate Validator).
- 📖 **OpenAPI 3 (Swagger)** — Fully documented and interactive API playground.

## 🚀 Quick Start

### 1. Requirements
- **Docker** & **Docker Compose**
- **JDK 21** (only if running locally without Docker)
- **Maven 3.x**

### 2. Development
The fastest way to get the project running is using Docker Compose:

# Clone the repository
git clone https://github.com/kalebzaki4/room-reservation-api

# Navigate to the folder
cd syncspace-api

# Start the services (API + MySQL)
docker-compose up -d

### 📂 Directory Structure

```plaintext
src/main/java/com/kalebzaki/room-reservation-api/
├── config/      # Security, Swagger, and App configurations
├── controllers/ # REST API Resource Providers
├── dto/         # Request/Response Data Transfer Objects
├── exceptions/  # Global Exception Handling & Custom Errors
├── models/      # Database Entities & Mappings
├── repositories/# Spring Data JPA Interfaces
└── services/    # Business Logic & Rule Validations
```

## 🛠 Scripts & Commands

| Command                    | Description                                           |
|----------------------------|-------------------------------------------------------|
| `./mvnw spring-boot:run`   | Starts the application locally.                       |
| `./mvnw clean package`     | Creates an optimized .jar production build.           |
| `./mvnw test`              | Runs the JUnit 5 and Mockito test suite.              |
| `docker-compose logs -f`   | View real-time logs from the API and MySQL.           |

## 📐 Architecture & Decisions

- **DTO Pattern**: Used to decouple the database layer from the client, ensuring security and API flexibility.
- **Global Error Handling**: Implemented `@ControllerAdvice` to return standardized error messages following RFC 7807.
- **Optimistic Locking**: Essential for reservation systems to handle simultaneous booking attempts without database overhead.

## 🤝 Contributing

1. Fork the project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the Branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Kaleb Zaki**  
Backend Developer specializing in Java & Spring Ecosystem.
