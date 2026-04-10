// write a program to built a methods for DMAS (Division, Multiplication, Addition, Subtraction) for given numbers and so on.

import java.util.Scanner;
public class CalculateDMAS {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number:");
        double num1 = sc.nextDouble();

        System.out.print("Enter the second number:");
        double num2 = sc.nextDouble();
        
        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
    if (b != 0) {
        return a / b;
    } else {
        System.out.println("Error: Division by zero is not allowed.");
        return 0;
    }
  }
}
