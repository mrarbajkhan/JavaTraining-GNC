// Program to create a BankAccount class with private variables
// and display masked account number (only last 4 digits visible)

import java.util.Scanner;

public class BankAccount {

    // 🔒 Private variables (data hiding)
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // ✅ Getter for account number (original - not used for display)
    public String getAccountNumber() {
        return accountNumber;
    }

    // ✅ Setter for account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // ✅ Getter for account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // ✅ Setter for account holder name
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // ✅ Getter for balance
    public double getBalance() {
        return balance;
    }

    // ✅ Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 🔐 Method to mask account number (only last 4 digits visible)
    public String getMaskedAccountNumber() {
        if (accountNumber.length() > 4) {
            // Extract last 4 digits
            String last4 = accountNumber.substring(accountNumber.length() - 4);
            return "XXXXXX" + last4; // Mask remaining digits
        } else {
            return accountNumber; // If length <= 4, show as it is
        }
    }

    public String getMaskedBalance() {
        String balanceStr = String.valueOf(balance);
        if (balanceStr.length() > 3) {
            String first3 = balanceStr.substring(0, 3);
            return first3 + "******"; // Mask balance for security
        } else {
            return balanceStr; // If length <= 3, show as it is
        }
    }

    // 🚀 Main method (program execution starts here)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create object of BankAccount class
        BankAccount account = new BankAccount();

        // 🧾 Taking input from user

        System.out.print("Enter the account number: ");
        String accNum = sc.nextLine();
        account.setAccountNumber(accNum);

        System.out.print("Enter the account holder name: ");
        String accHolderName = sc.nextLine();
        account.setAccountHolderName(accHolderName);

        System.out.print("Enter the balance: ");
        double accBalance = sc.nextDouble();
        account.setBalance(accBalance);

        // 📤 Display masked details

        System.out.println("\nBank Account Details:");
        System.out.println("Account Number: " + account.getMaskedAccountNumber()); // masked output
        System.out.println("Account Holder Name: " + account.getAccountHolderName());
        System.out.println("Balance: " + account.getMaskedBalance());

        // Close scanner
        sc.close();
    }
}