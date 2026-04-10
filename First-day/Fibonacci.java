// Write a program to print the Fibonacci series up to a given number using class and object.

public class Fibonacci {
    public static void main(String[] args) {

        int n = 10;

        int a = 0, b = 1;

        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");

            int c = a + b;
            a = b;
            b = c;
        }
    }
}