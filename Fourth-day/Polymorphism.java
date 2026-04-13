// write a program to create a ProductBilling using polymorphism. Create a base class named "Product" with attributes like "name" and "price". 
// Then, create two derived classes named "Electronics" and "Clothing" that inherit from the Product class. 
// Each derived class should have its own method to calculate the final price after applying a discount. In the main method, create objects of both derived classes, 
// set their attributes, and call the methods to calculate and display the final price for each product.

import java.util.Scanner;

// Base class Product
class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Derived class Electronics
class Electronics extends Product {
    Electronics(String name, double price) {
        super(name, price);
    }
    
    double calculateFinalPrice() {
        // 10% discount for electronics
        return price * 0.9;
    }
}

// Derived class Clothing
class Clothing extends Product {
    Clothing(String name, double price) {
        super(name, price);
    }
    
    double calculateFinalPrice() {
        // 20% discount for clothing
        return price * 0.8;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // enter the name of the electronic product
        System.out.println("\nElectronic product details: ");
        System.out.print("Enter the name of the electronic product: ");
        String electronicName = sc.nextLine();

        // enter the price of the electronic product
        System.out.print("Enter the price of the electronic product: ");
        double electronicPrice = sc.nextDouble();
        Electronics electronicProduct = new Electronics(electronicName, electronicPrice);

        // enter the name of the clothing product
        System.out.println("\nClothing product details: ");
        System.out.print("Enter the name of the clothing product: ");
        sc.nextLine(); // Consume the newline
        String clothingName = sc.nextLine();

        // enter the price of the clothing product
        System.out.print("Enter the price of the clothing product: ");
        double clothingPrice = sc.nextDouble();
        Clothing clothingProduct = new Clothing(clothingName, clothingPrice);

        // Calculate and display the final price for each product after applying the respective discounts.
        System.out.print("\nApplying 10% discount to the electronic product.");
        System.out.println("\nFinal price of the electronic product: " + electronicProduct.calculateFinalPrice());

        System.out.print("\nApplying 20% discount to the clothing product.");
        System.out.println("\nFinal price of the clothing product: " + clothingProduct.calculateFinalPrice());
        sc.close();

    }
    
}
