# ☕ Java Training Programs

This repository contains my Java training practice programs (Core Java).
All programs are organized day-wise and cover basic to intermediate concepts.

---

## 📅 Day 1 Programs

* Hello World Program
* Addition Program
* Factorial Number
* Fibonacci Series
* Finding Largest Number
* Palindrome Check
* Prime Number Check

---

## 📅 Day 2 Programs

* Bank Account (Encapsulation + Data Masking)
* Calculate DMAS (Division, Multiplication, Addition, Subtraction)
* Different Variable Example
* Display Student Details
* Employee Data
* Employee Static Example
* Parent-Child Relationship (Inheritance)
* Student Marks
* Student Name

---

## 📅 Day 3 Programs

* Abstraction (Used abstract class and abstract methods.)
* ClassObject (Created classes and objects to understand real-world.)
* CustomException (Created user-defined exceptions to handle specific error conditions.)
* ExceptionHandling (Used try-catch and finally blocks to handle runtime errors.)

---

## 📅 Day 4 Programs

* File Create
* Polymorphism
* Serialization
* Serialization to Deserialization

---

## 📅 Day 5 Programs

* JDBC Database Connectivity (Java ↔ MySQL Connection)
* InsertData (Insert records using PreparedStatement)
* ReadData (Fetch data using SELECT query and ResultSet)
* UpdateData (Update records using UPDATE query)
* DeleteData (Delete records using DELETE query)
* CRUDMenu (Menu-driven CRUD operations program)

---

### ⚙️ Features (Day 5)

* Connected Java application with MySQL database using JDBC
* Performed all CRUD operations
* Used PreparedStatement for secure queries
* Implemented menu-driven system
* Displayed structured output
* Handled exceptions

---

### 🧠 Concepts Used (Day 5)

* JDBC (Java Database Connectivity)
* DriverManager & Connection
* Statement vs PreparedStatement
* ResultSet handling
* executeQuery() vs executeUpdate()
* SQL Queries (INSERT, SELECT, UPDATE, DELETE)
* Exception Handling
* Scanner (User Input)

---

### 🗄️ Database Details

* Database Name: `studentdb`
* Table Name: `students`

Columns:

* id (INT)
* student_name (VARCHAR)
* marks (INT)

---

### ▶️ How to Run (Day 5 Programs)

```
javac -cp ".;mysql-connector-j-9.6.0.jar" CRUDMenu.java
java -cp ".;mysql-connector-j-9.6.0.jar" CRUDMenu
```

---

## 🧠 Assignment: Result Processing System

### 📌 Description

This program processes student results using Java.
It takes input, validates marks, and displays Pass/Fail results.

---

### ⚙️ Features

* Accepts up to 5 students
* Validates marks (0–100)
* Displays results in table format
* Uses exception handling

---

### 🛠️ Concepts Used

* HashMap
* Scanner
* Conditional Statements
* Loops
* Exception Handling
* Basic Encapsulation

---

### 📊 Sample Output

```
Student Results:
--------------------------------
Name        Marks   Result
--------------------------------
Arbaj       85      Pass
Ali         30      Fail
--------------------------------
```

---

## 🎓 Final Assignment: Smart Campus Management System

### 📌 Description

This project is a **console-based Smart Campus Management System** developed using Java and MySQL.
It allows users to manage students, courses, and enrollments efficiently with database integration.

---

### 🚀 Features

* Add Student
* Add Course
* Enroll Student
* View Students
* View Enrollments
* MySQL Integration using JDBC
* Multithreading (Enrollment Processing)
* File Handling

---

### 🛠️ Technologies Used

* Core Java
* JDBC
* MySQL
* Multithreading
* File Handling

---

### 🧠 Concepts Used

* OOP (Classes & Objects)
* Exception Handling
* JDBC Connectivity
* PreparedStatement
* SQL Queries (INSERT, SELECT, JOIN)
* Multithreading
* Collections (HashMap, ArrayList)
* File Handling

---

### 🗃️ Database Details

Database: `smartcampus`

Tables:

**students**

* student_id (INT, PRIMARY KEY)
* name (VARCHAR)
* email (VARCHAR)

**courses**

* course_id (INT, PRIMARY KEY)
* course_name (VARCHAR)
* fee (DOUBLE)

**enrollments**

* student_id (INT)
* course_id (INT)

---

### ⚙️ How to Run

```
javac -cp ".;mysql-connector-j-8.0.33.jar" SmartCampusSystem.java
java -cp ".;mysql-connector-j-8.0.33.jar" SmartCampusSystem
```

---

### 📊 Sample Output

```
--- Smart Campus Management ---
1. Add Student
2. Add Course
3. Enroll Student
4. View Students
5. View Enrollments
6. Exit
```

---

### 📸 Screenshots

(Add screenshots here)

* Menu Screen
* Add Student
* View Students
* Enrollment Output

---

## 🚀 Concepts Covered

* Java Basics
* User Input
* Loops & Conditions

### 🔹 OOP Concepts

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction

---

## 🛠️ Tools & Technologies

* Java
* VS Code
* MySQL
* Git & GitHub

---

## 📂 Project Structure

JavaTraining/
├── First-day/
├── Second-day/
├── Three-day/
├── Four-day/
├── Fifth-day/
├── Assignment-01/
├── Assignment-02/
└── README.md

---

## 💡 Learning Outcome

* Strong understanding of Core Java
* Experience with JDBC & MySQL
* Ability to build real-world projects
* Improved problem-solving skills
* Hands-on GitHub usage

---

## 👨‍💻 Created by Arbaj Khan
