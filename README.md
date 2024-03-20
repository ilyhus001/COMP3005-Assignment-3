# COMP3005-Assignment-3
# PostgreSQL JDBC Connection
This Java program establishes a connection with a PostgreSQL database and demonstrates basic CRUD (Create, Read, Update, Delete) operations on a table named students.

# Prerequisites
-PostgreSQL database installed on your local machine.
-JDBC driver for PostgreSQL.

# Setup
- Make sure you have a PostgreSQL database running.
- Replace the connection URL, username, and password in the PostgreSQLJDBCConnection class with your database credentials.
java
- Copy code: 
-- private static final String url = "jdbc:postgresql://localhost:5432/Assignment3";
-- private static final String user = "postgres";
-- private static final String password = "your_password";

# Usage
Compile the PostgreSQLJDBCConnection.java file.


-Copy code:
--javac PostgreSQLJDBCConnection.java

-Run the compiled Java program.

-Copy code:
--java PostgreSQLJDBCConnection

# Operations
-The program demonstrates the following operations:

Add a Student: Inserts a new student into the students table.
Update Student Email: Updates the email of a student based on their ID.
Delete Student: Deletes a student from the database based on their ID.
Get All Students: Retrieves and prints details of all students from the students table.


# Youtube link: https://youtu.be/iU4JGhGbGqQ
