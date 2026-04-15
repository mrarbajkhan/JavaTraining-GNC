// Write a program in which collect to a drive on MySQL driver and print system connected and database connected successfully.

/* Steps to connect to MySQL database using JDBC
   Step 01: Load the MySQL JDBC driver
   Step 02: Create/Establish a connection to the database
   Step 03: Execute SQL queries
   Step 04: Close the connection
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter marks: ");
        int studentMarks = sc.nextInt();

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver loaded successfully");

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://sql.freedb.tech:3306/freedb_student_db",
                "freedb_student_user",
                "x!Xgz4%nxwHzrZ$"
            );

            System.out.println("✅ Database connected successfully");

            // Insert query
            String query = "INSERT INTO students_db (name, marks) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentName);
            ps.setInt(2, studentMarks);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Data inserted successfully");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }

        sc.close();
    }
}

