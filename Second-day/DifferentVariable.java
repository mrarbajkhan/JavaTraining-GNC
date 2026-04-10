//Write a program to differencate the inistant variable and global variable.

import java.util.Scanner;
public class DifferentVariable {
    int rollNo; // Global variable
    String name; // Global variable

    //constructor to initialize the global variables
    DifferentVariable(int rollNo, String name) {
        this.rollNo = rollNo; // Assigning the value of the local variable to the global variable
        this.name = name; // Assigning the value of the local variable to the global variable
    }

    void display() {
        System.out.println("Roll No: " + rollNo); // Accessing the global variable
        System.out.println("Name: " + name); // Accessing the global variable
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the roll number of the student from user input.
        System.out.print("Enter the roll number of the student: ");
        int rollNo = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Get the name of the student from user input.
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();

        // Create an instance of DifferentVariable class and initialize it with user input
        DifferentVariable student = new DifferentVariable(rollNo, name);

        // Display the details of the student
        student.display();

        // Close the scanner
        sc.close();
    }
}
