/* Write the java program used to insert data (id, student_name, marks) into the "students" table of the "studentdb" MySQL database using JDBC.

    ----------------------------------------------------------------
    Steps to Insert Data into Database using JDBC:
    ----------------------------------------------------------------

    Step 01: Import Required Packages
    1.1) Import java.sql package classes (Connection, DriverManager, PreparedStatement).
    1.2) Import java.util.Scanner for user input.

    ----------------------------------------------------------------

    Step 02: Load the MySQL JDBC Driver
    2.1) Use Class.forName("com.mysql.cj.jdbc.Driver") to load the driver class.
    2.2) This step enables Java to communicate with MySQL database.
    2.3) Handle ClassNotFoundException if the driver is not found.

    ----------------------------------------------------------------

    Step 03: Establish Connection to Database
    3.1) Define database URL (jdbc:mysql://localhost:3306/studentdb).
    3.2) Provide username and password (e.g., root and password).
    3.3) Use DriverManager.getConnection() to establish connection.
    3.4) Handle SQLException if connection fails.

    ----------------------------------------------------------------

    Step 04: Take Input from User
    4.1) Use Scanner class to take input (id, student name, marks).
    4.2) Store input values in variables.

    ----------------------------------------------------------------

    Step 05: Prepare SQL INSERT Query
    5.1) Write SQL query:
         INSERT INTO students (id, student_name, marks) VALUES (?, ?, ?)
    5.2) Use PreparedStatement to avoid SQL Injection and handle dynamic values.

    ----------------------------------------------------------------

    Step 06: Set Values in PreparedStatement
    6.1) Use setInt() and setString() methods to set values.
    6.2) Map input values to query parameters (? placeholders).

    ----------------------------------------------------------------

    Step 07: Execute the Query
    7.1) Use executeUpdate() method to run INSERT query.
    7.2) It returns number of rows affected.
    7.3) Check if rows > 0 → Data inserted successfully.

    ----------------------------------------------------------------

    Step 08: Close Resources
    8.1) Close PreparedStatement object.
    8.2) Close Connection object.
    8.3) This step is important to free database resources.

    ----------------------------------------------------------------

    Step 09: Exception Handling
    9.1) Use try-catch block to handle exceptions.
    9.2) Print error message if any exception occurs.

    ----------------------------------------------------------------

    Conclusion:
    This program successfully connects to MySQL database
    and inserts user-provided data into the students table.

*/


import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "arbaj0318@mysql";

        Scanner sc = new Scanner(System.in);

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully");

            // Connect to database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Database connected successfully");

            // Insert query
            String query = "INSERT INTO studentdb (id, student_name, marks) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("Enter id: ");
            int studentId = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();


            System.out.print("Enter marks: ");
            int studentMarks = sc.nextInt();

            ps.setInt(1, studentId);
            ps.setString(2, studentName);
            ps.setInt(3, studentMarks);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Data inserted successfully");
            }
            else {
                System.out.println("❌ Data insertion failed");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }
    }
}
