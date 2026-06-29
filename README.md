# 📝 Spring Boot To-Do List Application

A full-stack **To-Do List Web Application** developed using **Java, Spring Boot, Spring Data JPA, Thymeleaf, and MySQL**. This application allows users to efficiently manage their daily tasks by providing complete CRUD (Create, Read, Update, Delete) functionality through a simple and intuitive web interface.

---

## 🚀 Features

* ➕ Add new tasks
* 📋 View all tasks
* ✏️ Update existing tasks
* ❌ Delete tasks
* 💾 Store task data in MySQL database
* 🌐 User-friendly interface built with Thymeleaf
* ⚡ Fast and lightweight Spring Boot application

---

## 🛠️ Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Thymeleaf
* MySQL
* Maven
* HTML
* CSS

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── service
│   │   ├── repository
│   │   ├── entities
│   │   └── ToDoListApplication.java
│   └── resources
│       ├── templates
│       └── application.properties
```

---

## ⚙️ Prerequisites

Before running the project, ensure you have:

* Java 17 or later
* Maven
* MySQL Server
* Spring Tool Suite (STS) or IntelliJ IDEA
* Git

---

## 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE todolist;
```

Configure your own database credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ How to Run the Project

1. Clone the repository.
2. Open the project in STS or IntelliJ IDEA.
3. Create the `todolist` database in MySQL.
4. Update `application.properties` with your own database credentials.
5. Run `ToDoListApplication.java`.
6. Open your browser and visit:

## 👩‍💻 Author

**Sujata Patil**

Aspiring Java Backend Developer

---

⭐ If you found this project useful, consider giving it a star on GitHub.
