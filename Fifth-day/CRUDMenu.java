/*
===============================================================================
🔷 Program Title   : CRUDMenu.java
🔷 Technology Used : Java (JDBC) + MySQL
🔷 Author          : [ Arbaj Khan ]
===============================================================================

🎯 PURPOSE:
This program provides a menu-driven interface to perform CRUD operations
(Create, Read, Update, Delete) on the "students" table in the "studentdb"
database using JDBC.

===============================================================================
🧩 WORKFLOW OVERVIEW:
-------------------------------------------------------------------------------
1️⃣  Establish connection between Java and MySQL database
2️⃣  Display menu repeatedly using loop
3️⃣  Take user choice as input
4️⃣  Perform operation based on user selection
5️⃣  Repeat until user chooses Exit
===============================================================================

🛠️ FUNCTIONAL MODULES:
-------------------------------------------------------------------------------

🔹 [1] INSERT OPERATION (Create)
    ➤ Takes student id, name, and marks from user
    ➤ Uses PreparedStatement with INSERT query
    ➤ Adds new record into database table

🔹 [2] VIEW OPERATION (Read)
    ➤ Executes SELECT query using Statement
    ➤ Uses ResultSet to fetch all records
    ➤ Displays data in tabular format

🔹 [3] UPDATE OPERATION
    ➤ Takes existing student ID from user
    ➤ Accepts new name and marks
    ➤ Updates record using UPDATE query with WHERE condition

🔹 [4] DELETE OPERATION
    ➤ Takes student ID from user
    ➤ Deletes matching record using DELETE query

🔹 [5] EXIT
    ➤ Terminates program execution
    ➤ Closes database connection and scanner

===============================================================================
⚙️ DATABASE CONFIGURATION:
-------------------------------------------------------------------------------
✔ Database Name : studentdb
✔ Table Name    : students
✔ Columns       : id (INT), student_name (VARCHAR), marks (INT)

===============================================================================
🔐 JDBC COMPONENTS USED:
-------------------------------------------------------------------------------
✔ DriverManager  → To establish database connection
✔ Connection     → Represents connection with database
✔ Statement      → Used for SELECT query
✔ PreparedStatement → Used for INSERT, UPDATE, DELETE
✔ ResultSet      → To process fetched data

===============================================================================
⚠️ KEY POINTS / BEST PRACTICES:
-------------------------------------------------------------------------------
✔ Always use PreparedStatement for dynamic queries (security + performance)
✔ Use WHERE clause in UPDATE and DELETE to avoid affecting all records
✔ Close all resources (Connection, Statement, Scanner)
✔ Handle exceptions properly using try-catch

===============================================================================
🏁 CONCLUSION:
This program demonstrates a complete implementation of CRUD operations
in a structured and user-friendly way using a menu-driven approach.
===============================================================================
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDMenu {
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

            Scanner sc = new Scanner(System.in);
            int choice;

            while (true) {
                // Display menu
                System.out.println("\n===== CRUD Menu =====");
                System.out.println("1. Insert Data");
                System.out.println("2. Read Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    // 🔹 INSERT
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        String insertQuery = "INSERT INTO studentdb (id, student_name, marks) VALUES (?, ?, ?)";
                        PreparedStatement ps1 = con.prepareStatement(insertQuery);
                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setInt(3, marks);

                        int insertRows = ps1.executeUpdate();
                        if (insertRows > 0)
                            System.out.println("The New Data Inserted Successfully");
                        else 
                            System.out.println("❌ Insert Failed");
                            
                        break;

                    // 🔹 READ (view)
                    case 2:
                        String selectQuery = "SELECT * FROM studentdb";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\nID | Name \t| Marks");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + " | " +
                                rs.getString("student_name") + " | " +
                                rs.getInt("marks")
                            );
                        }
                        break;

                    // 🔹 UPDATE
                    case 3:
                        System.out.print("Enter ID to update: ");
                        int oldId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Marks: ");
                        int newMarks = sc.nextInt();

                        String updateQuery = "UPDATE studentdb SET student_name=?, marks=? WHERE id=?";
                        PreparedStatement ps2 = con.prepareStatement(updateQuery);
                        ps2.setString(1, newName);
                        ps2.setInt(2, newMarks);
                        ps2.setInt(3, oldId);

                        int updateRows = ps2.executeUpdate();
                        if (updateRows > 0)
                            System.out.println("The New Data Updated Successfully");
                        else
                            System.out.println("❌ No record found with this ID");
                        break;

                    // 🔹 DELETE
                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = "DELETE FROM studentdb WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(deleteQuery);
                        ps3.setInt(1, deleteId);

                        int deleteRows = ps3.executeUpdate();
                        if (deleteRows > 0)
                            System.out.println("The Data Deleted Successfully");
                        else
                            System.out.println("❌ No record found with this ID");
                        break;

                    // 🔹 EXIT
                    case 5:
                        System.out.println("👋 Exiting... See you next time!");
                        con.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("❌ Invalid choice - Please try again");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e);
        }
    }
}