// Write a program to find the largest number among three numbers using class and object.

import java.util.Scanner;
public class FindingLargeNo {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        int largest = num1;

        if (num2 > largest) {
            largest = num2;
        }

        if (num3 > largest) {
            largest = num3;
        }

        System.out.println("The largest number among " + num1 + ", " + num2 + " and " + num3 + " is: " + largest);

        sc.close();
    }
    
}
