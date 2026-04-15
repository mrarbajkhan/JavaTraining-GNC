/* Write the java program used to update existing data (student_name, marks, etc.) in the "students" table of the "studentdb" MySQL database using JDBC.

    ----------------------------------------------------------------
    Steps to Update Data in Database using JDBC:
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
        4.1) Use Scanner class to take input:
             - id (which record to update)
             - new name or new marks
        4.2) Store input values in variables.

    ----------------------------------------------------------------

    Step 05: Prepare SQL UPDATE Query
        5.1) Write SQL query:
             -UPDATE students SET student_name = ?, marks = ? WHERE id = ?
        5.2) Use PreparedStatement to safely pass dynamic values.

    ----------------------------------------------------------------

    Step 06: Set Values in PreparedStatement
        6.1) Use setString() and setInt() methods to set values.
        6.2) Map input values to query parameters (? placeholders).

    ----------------------------------------------------------------

    Step 07: Execute the Query
        7.1) Use executeUpdate() method to run UPDATE query.
        7.2) It returns number of rows affected.
        7.3) If rows > 0 → Data updated successfully.
        7.4) If rows = 0 → No record found with given id.

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
    This program successfully updates existing data in the database
    based on user input.

*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "arbaj0318@mysql";

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            // Connect to database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully");

            // Take input from user
            //take input for new id.
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID of student to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline

            //take input for new name.
            System.out.print("Enter the new name of student: ");
            String newName = sc.nextLine();

            //take input for new marks.
            System.out.print("Enter the new marks of student: ");
            int newMarks = sc.nextInt();

            // Prepare SQL UPDATE query
            String query = "UPDATE studentdb SET student_name = ?, marks = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set values in PreparedStatement
            pstmt.setString(1, newName);
            pstmt.setInt(2, newMarks);
            pstmt.setInt(3, id);

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("No record found with ID: " + id);
            }

            // Close resources
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error, you data cannot be updated: " + e);
        }
    }
}
