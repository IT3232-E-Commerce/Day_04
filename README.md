# Student-Course Management System

A RESTful API built with Spring Boot for managing students and courses in an educational institution.

## Overview

This is a Spring Boot REST API application that provides comprehensive CRUD (Create, Read, Update, Delete) operations for managing students and courses. The system allows administrators to maintain student records and course information through HTTP endpoints.

## Features

- **Student Management**
  - Add new students
  - Retrieve student information (individual or all)
  - Update student details
  - Delete student records

- **Course Management**
  - Add new courses
  - Retrieve course information (individual or all)
  - Update course details
  - Delete course records

- **RESTful API Design**
  - Standard HTTP methods (GET, POST, PUT, DELETE)
  - JSON request/response format
  - Clean URL structure

## Technology Stack

- **Backend Framework**: Spring Boot 3.5.0
- **Language**: Java 17
- **Build Tool**: Maven
- **Architecture**: REST API
- **Data Storage**: In-memory (HashMap)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use included Maven wrapper)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd system
   ```

2. **Run using Maven wrapper (recommended)**
   ```bash
   # On Unix/Mac
   ./mvnw spring-boot:run
   
   # On Windows
   mvnw.cmd spring-boot:run
   ```

3. **Alternative: Run using Maven**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Base URL: `http://localhost:8080`
   - The application will start on port 8080 by default

## API Endpoints

### Student Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by registration number |
| POST | `/students` | Add new student |
| PUT | `/students/{id}` | Update student by registration number |
| DELETE | `/students/{id}` | Delete student by registration number |

### Course Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/courses` | Get all courses |
| GET | `/courses/{id}` | Get course by course ID |
| POST | `/courses` | Add new course |
| PUT | `/courses/{id}` | Update course by course ID |
| DELETE | `/courses/{id}` | Delete course by course ID |

## Screenshots

![1](https://github.com/user-attachments/assets/a7c71a09-0815-4c1d-8f00-96849e63fbf7)
![2](https://github.com/user-attachments/assets/c2e1591d-b6cd-404d-b8ef-4705f55cbe06)
![3](https://github.com/user-attachments/assets/1d12483c-27a7-40ec-a466-b18f7733cfb6)
![4](https://github.com/user-attachments/assets/731326d6-553a-4463-9849-731461c5b460)
