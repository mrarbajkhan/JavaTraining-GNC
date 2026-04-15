/*Write the java program used to delete a specific record from the "students" table in the "studentdb" MySQL database using JDBC.

    ----------------------------------------------------------------
    Steps to Delete Data from Database using JDBC:
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
    4.1) Use Scanner class to take input (id of the record to delete).
    4.2) Store input value in a variable.

    ----------------------------------------------------------------

    Step 05: Prepare SQL DELETE Query
    5.1) Write SQL query:
         DELETE FROM students WHERE id = ?
    5.2) Use PreparedStatement to safely pass dynamic values.

    ----------------------------------------------------------------

    Step 06: Set Value in PreparedStatement
    6.1) Use setInt() to set the id value.
    6.2) Map input value to query parameter (? placeholder).

    ----------------------------------------------------------------

    Step 07: Execute the Query
    7.1) Use executeUpdate() method to run DELETE query.
    7.2) It returns number of rows affected.
    7.3) If rows > 0 → Data deleted successfully.
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
    This program successfully deletes a record from the database
    based on user-provided id.

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
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
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the ID of the student to delete: ");
            int idToDelete = sc.nextInt();

            // Prepare DELETE query
            String query = "DELETE FROM studentdb WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(query);

            // Set value
            pstmt.setInt(1, idToDelete);

            // Execute query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Data deleted successfully");
            } else {
                System.out.println("❌ No record found with ID: " + idToDelete);
            }

            // Close resources
            pstmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println("❌ Error while deleting data: " + e);
        }
    }
}