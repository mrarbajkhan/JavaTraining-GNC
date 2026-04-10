// Write a program to create a constructor of employee class to initialize the employee data such as name, id and salary.
import java.util.Scanner;
class EmployeeData {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        // Get the name of the employee from user input.
        System.out.print("Enter the name of the employee:");
        String name = sc.nextLine();

        // Get the id of the employee from user input.
        System.out.print("Enter the id of the employee:");
        int id = sc.nextInt();

        // Get the salary of the employee from user input.
        System.out.print("Enter the salary of the employee:");
        double salary = sc.nextDouble();

        // Display the details of the employee.
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);

        // Close the scanner.
        sc.close();
    }
    
}
