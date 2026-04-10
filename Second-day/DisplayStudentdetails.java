// Write a program to display the details of the student such as name, roll no and marks.
import java.util.Scanner;
class DisplayStudentdetails {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Get the name of the student from user input.
            System.out.print("Enter the name of the students:");
            String name = sc.nextLine();

            // Get the roll number of the student from user input.
            System.out.print("Enter the roll number of the student:");
            int rollNo = sc.nextInt();

            // Get the marks of the student from user input.
            System.out.print("Enter the marks of the student:");
            String marks = sc.next();

            // Display the details of the student.
            System.out.println("\nStudent Details:");
            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Marks: " + marks);

            // Close the scanner.
            sc.close();

        }
    }
