/* Write a Java program to read (fetch) data from the "students" table in the "studentdb" MySQL database using JDBC and display it on the console.

    ---------------------------------------------------------------
    Steps to Read Data from Database using JDBC:
    ---------------------------------------------------------------

    Step 01: Import Required Packages
    1.1) Import java.sql package classes (Connection, DriverManager, Statement, ResultSet).
    1.2) These classes are required for database connectivity and data handling.

    ---------------------------------------------------------------

    Step 02: Load the MySQL JDBC Driver
    2.1) Use Class.forName("com.mysql.cj.jdbc.Driver") to load the driver class.
    2.2) This step ensures that the Java program can communicate with MySQL.
    2.3) Handle ClassNotFoundException if the driver is not found.

    ---------------------------------------------------------------

    Step 03: Establish Connection to Database
    3.1) Define database URL (jdbc:mysql://localhost:3306/studentdb).
    3.2) Provide username and password (e.g., root and password).
    3.3) Use DriverManager.getConnection() to establish connection.
    3.4) Handle SQLException if connection fails.

    ---------------------------------------------------------------

    Step 04: Create Statement Object
    4.1) Use Connection object to create a Statement.
    4.2) Statement is used to execute SQL queries.

    ---------------------------------------------------------------

    Step 05: Execute SELECT Query
    5.1) Write SQL query: SELECT * FROM students.
    5.2) Use executeQuery() method to run the SELECT query.
    5.3) Store the result in a ResultSet object.

    ---------------------------------------------------------------

    Step 06: Process the ResultSet
    6.1) Use while(rs.next()) to iterate through each row.
    6.2) Retrieve column values using:
         - rs.getInt("id")
         - rs.getString("student_name")
         - rs.getInt("marks")
    6.3) Display the fetched data on the console.

    ---------------------------------------------------------------

    Step 07: Close Resources
    7.1) Close ResultSet object.
    7.2) Close Statement object.
    7.3) Close Connection object.
    7.4) This step is important to free database resources.

    ---------------------------------------------------------------

    Step 08: Exception Handling
    8.1) Use try-catch block to handle exceptions.
    8.2) Print error message if any exception occurs.

    ---------------------------------------------------------------

    Conclusion:
    This program successfully connects to MySQL database,
    retrieves data from the students table, and displays it.

*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "arbaj0318@mysql";

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Driver loaded successfully");

            // Connect to database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(" Database connected successfully");
            System.out.println(" Data fetched successfully");
            System.out.println(" -----------------------------");
            System.out.println(" ID | Name \t| Marks");
            System.out.println(" -----------------------------");

            // SELECT query
            String query = "SELECT * FROM studentdb.studentdb;";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Display data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("student_name");
                int marks = rs.getInt("marks");

                System.out.println(id + " | " + name + " | " + marks);
                System.out.println("-----------------------------");

            }

            con.close();

        } catch (Exception e) {
            System.out.println(" Error can not read the data: " + e);
        }
    }
}

