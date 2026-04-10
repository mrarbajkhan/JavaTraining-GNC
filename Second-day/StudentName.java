// Write a program to input the name of the student and print the name of the student, character length, upper case and lower case.

import java.util.Scanner;
class StudentName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //get the name of the student from user input.
        System.out.print("Enter the name of the student: ");
        
        //store the name in a variable.
        String name = sc.nextLine();
      
        //print the original.
        System.out.println("Original Name: " + name);

        //find and print the character length of the name.
        System.out.println("Character Length: " + name.length());

        //find and print the name in upper case and lower case.
        System.out.println("Upper Case: " + name.toUpperCase());

        //find and print the name in lower case.
        System.out.println("Lower Case: " + name.toLowerCase());

        //close the scanner.
        sc.close();
    }
    
}
