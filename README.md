# 🛍️ ShopSmart - Smart Mall Recommendation System

ShopSmart is a Spring Boot based backend application that recommends the best malls to users based on their **budget, crowd preference, and distance**.

The application uses **Dijkstra's shortest path algorithm** to calculate the shortest distance between the user's source location and available malls.

---

## 🚀 Features

- Mall recommendation based on user preferences
- Filter malls based on:
  - Budget
  - Crowd density
- Calculate shortest distance using Dijkstra's algorithm
- Return the shortest path from source to recommended mall
- REST API using Spring Boot
- MySQL database integration
- Input validation using Jakarta Validation
- Layered architecture using Controller, Service, Repository, DTO, Model and Algorithm packages

---

## 🛠️ Technologies Used

- Java 19
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API
- Dijkstra's Shortest Path Algorithm
- IntelliJ IDEA
- Postman

---

## 📂 Project Structure

```text
src/main/java/com/shopsmart/shopsmart
│
├── algorithm
│   ├── Dijkstra.java
│   └── Result.java
│
├── controller
│   └── RecommendationController.java
│
├── dto
│   ├── RecommendationRequest.java
│   └── RecommendationResponse.java
│
├── graph
│   └── Graph.java
│
├── model
│   ├── Edge.java
│   ├── Mall.java
│   └── NodeDistance.java
│
├── repository
│   └── MallRepository.java
│
└── service
    └── RecommendationService.java
