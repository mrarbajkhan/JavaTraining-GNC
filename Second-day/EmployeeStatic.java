// Write a program in which we create employee objects with shared companyName using static variable and display the details of the employee.

public class EmployeeStatic {
    int empId;
    String empName;
    static String companyName = "Arbaj Tech Solutions Pvt. Ltd."; // Static variable shared by all objects

    // Constructor to initialize instance variables
    EmployeeStatic(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Company Name: " + companyName);
    }

    public static void main(String[] args) {
        // Create employee objects
        EmployeeStatic emp1 = new EmployeeStatic(1, "Arbaj");
        EmployeeStatic emp2 = new EmployeeStatic(2, "Raj");
        EmployeeStatic emp3 = new EmployeeStatic(3, "Vishal");

        // Display employee details
        emp1.display();
        emp2.display();
        emp3.display();
    }
}
