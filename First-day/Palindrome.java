// Write a program to check whether a given string is a palindrome or not using class and object.

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String rev = "";

        // reverse string manually
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        sc.close();
    }
}



/*
 * Palindrome kya hota hai?
 * Jo word aage se aur peeche se same ho
 * 
 * Examples:
 * madam ✅ palindrome
 * racecar ✅ palindrome
 * hello ❌ not palindrome
 */