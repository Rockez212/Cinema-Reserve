
# 🎬 Cinema Reserve API

A modern, RESTful web service for booking movie tickets and managing cinema screenings with a secure and scalable architecture.

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/) 
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)](https://spring.io/projects/spring-boot) 
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)](https://www.postgresql.org/) 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

---

## 📌 Project Overview

Cinema Reserve API enables users to:
- **Register and log in** securely to access personalized features
- **Book movie seats** for upcoming screenings
- **Manage bookings** and view booking history
- Allow **admins** to manage movies and screenings efficiently

---

## 🧰 Tech Stack

- **Java 17**: Modern, robust programming language
- **Spring Boot**: Framework for building production-ready applications
- **Spring Security**: Secure authentication and authorization
- **JWT (JSON Web Token)**: Token-based authentication
- **Lombok**: Reduces boilerplate code
- **BCrypt**: Password hashing for enhanced security
- **PostgreSQL / MySQL**: Relational database for persistent storage
- **Hibernate / JPA**: ORM for seamless database interaction

---

## 🚀 Getting Started

Follow these steps to set up and run the Cinema Reserve API locally.

### Prerequisites
- Java 17 JDK
- Maven
- PostgreSQL (or MySQL)
- Git

### 1. 📥 Clone the Repository
```bash
git clone https://github.com/Rockez666/Cinema-Reserve.git
cd Cinema-Reserve
```

### 2. ⚙️ Configure the Application
Create a file named `application.properties` in `src/main/resources/` with the following content:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=none
jwt_secret=SECRET228
```
> **Note**: Replace `postgres` credentials with your database settings and update `jwt_secret` with a secure key.

### 3. 🛠️ Build and Run
```bash
mvn clean install
mvn spring-boot:run
```
The API will be available at `http://localhost:8080`.

---

## 📡 API Endpoints

### Authentication
| Method | Endpoint              | Description                | Request Body Example                          |
|--------|-----------------------|----------------------------|----------------------------------------------|
| POST   | `/auth/register`      | Register a new user        | `{"username": "user", "email": "user@example.com", "password": "pass123"}` |
| POST   | `/auth/login`         | Log in and get JWT token   | `{"username": "user", "password": "pass123"}` |

**Responses**:
- Register: `"Successfully registered"`
- Login: `{"accessToken": "JWT_ACCESS_TOKEN"}`

### Booking
| Method | Endpoint              | Description                | Request Body Example                          |
|--------|-----------------------|----------------------------|----------------------------------------------|
| POST   | `/bookings`           | Book a movie seat          | `{"movieId": "1", "row": "A", "numberSeats": "5"}` |
| GET    | `/users`              | Retrieve user bookings     | -                                            |

**Responses**:
- Booking: `"Your seat has been successfully booked"`
- Get Bookings: List of user bookings

### Admin Service
| Method | Endpoint                     | Description                | Request Body Example                          |
|--------|------------------------------|----------------------------|----------------------------------------------|
| POST   | `/admin/movies`              | Add a new movie            | `{"title": "Fight Club (1999)", "description": "An office worker...", "durationMinutes": 139}` |
| POST   | `/admin/screenings`          | Add a new screening        | `{"movieId": 1, "startTime": "2025-11-15T14:25:00", "hallName": "Main Hall"}` |
| DELETE | `/admin/movies/{id}`         | Delete a movie             | -                                            |
| DELETE | `/admin/screenings/{id}`     | Delete a screening         | -                                            |

**Responses**:
- Create Movie: `"Successfully added movie"`
- Create Screening: `"Successfully added screening"`
- Delete Movie: `"Successfully deleted movie with id: {id}"`
- Delete Screening: `"Successfully deleted screening with id: {id}"`

---

## 📂 Project Structure
```
src/main/java/project/cinemareserve/
├── controller/       # REST API controllers
├── service/          # Business logic (e.g., authentication, booking)
├── security/         # Spring Security configuration
├── jwt/              # JWT utilities
└── model/            # Entity classes for JPA
```

---

## 🤝 Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## 📜 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 📬 Contact
For questions or feedback, reach out to [Rockez666](https://github.com/Rockez666).

Enjoy building with Cinema Reserve API! 🍿
