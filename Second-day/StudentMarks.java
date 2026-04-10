//Creat and array to store marks of the 05 studens then using loop.  
import java.util.Scanner;
class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5]; // Array to store marks of 5 students

        // Input marks for each student
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Display the marks of each student
        System.out.println("\nMarks of the students:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }

        sc.close();
    }
    
}
