// ==========================================
// Assignment 01: Result Processing System
// Student Name: Arbaj Khan
// Student ID: 25665386
// Section: D
// ==========================================

// Description:
// This program stores student names and marks using HashMap.
// It takes input from the user and displays the result.(Pass/Fail) based on the marks entered.

// Instructions:
// 1. Take student name and marks as input
// 2. Validate the input (marks should be between 0 and 100)
// 3. Condition Statement:
//  - If marks >= 40, grade is "Pass"
//  - If marks < 40, grade is "Fail"
// 4. Store the student name and grade in a HashMap
// 5. Display the result
// 6.Exception Handling:
//   -Using try-catch blocks to handle invalid input.
//***********************************************************************************************************


// Note: The program allows a maximum of 5 students to be entered. If the user tries to enter more than 5 students, an exception will be thrown.

/* Hashmap is used to store student names and their corresponding marks, and the program validates the input to ensure that marks are within the specified range. 
   The results are displayed in a formatted manner, showing the student's name, marks, and whether they passed or failed.*/

import java.util.HashMap;
import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {

        // HashMap to store student names and their corresponding marks
        HashMap<String, Integer> studentMarks = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int maxStudents = 5; // Maximum number of students to input

        try {
            System.out.print("Enter number of students (max 5): ");
            int num = sc.nextInt();
            sc.nextLine(); // Consume the newline

            // Validate the number of students
            if (num > maxStudents || num <= 0) {
                throw new Exception("Invalid number of students! Please enter a number between 1 and " + maxStudents);
            }

            // loop to take student names and marks as input
            for (int i = 0; i < num; i++) {
                System.out.print("Enter student name:");
                String name = sc.nextLine();

                System.out.print("Enter marks for " + name + ":");
                int marks = sc.nextInt();
                sc.nextLine(); // Consume the newline

                // Validate the marks
                if (marks < 0 || marks > 100) {
                    throw new Exception("Invalid marks for " + name + ". Marks should be between 0 and 100.");
                }

                // Store the student name and marks in the HashMap
                studentMarks.put(name, marks);
            }

            // Display the results in tabular format
            System.out.println("\nStudent Results:");
            System.out.println("------------------------------");
            System.out.println("Name\t\tMarks\tResult");
            System.out.println("------------------------------");

            // Loop through the HashMap to display each student's name, marks, and result
            for (String name : studentMarks.keySet()) {
                int marks = studentMarks.get(name);
                String result;

                if (marks >= 40) {
                    result = "😎 Pass";
                } 
                else 
                {
                    result = "😞 Fail";
                }

                // \t is used to create a tab space for better formatting of the output
                System.out.println(name + "\t\t\t" + marks + "\t\t" + result);
            }

            System.out.println("------------------------------");
        }
        // Catch any exceptions that occur during input validation and display an error message
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        sc.close();
    }
}      