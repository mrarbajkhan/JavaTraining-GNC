/*
In java Abstraction can be done in two ways 
1. Abstract Class
here We will define a class with abstract methods and concrete methods
    Step 1: Creating a class using abstract keyword
    Step 2: Define abstract methods (methods without a body) and concrete methods (methods with a body) in the abstract class.
    Step 3: Create a subclass that extends the abstract class and provides implementations for the abstract methods.
    Step 4: Create an object of the subclass and call the methods to demonstrate abstraction.
    Step 5: Run the program to see how abstraction works in Java.

2. Interface is based on "can do" relationship and abstract class is based on "is a" relationship
 Step 1: Create a interface using the interface keyword.
 Step 2: Define abstract methods (methods without a body) in the interface.
    Step 3: Create a class that implements the interface and provides implementations for the abstract methods. 
    Step 4: Create an object of the class that implements the interface and call the methods to demonstrate abstraction.
    Step 5: Run the program to see how abstraction works in Java.
*/

abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();

    // Regular method
    public void sleep() {
        System.out.println(" The animal is sleeping: Zzz... Zzz...");
    }
}

class Dog extends Animal {
    // Providing implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println("The Dog sounds: Woof! Woof!");
    }
}
class Bird extends Animal {
    // Providing implementation for the abstract method
    @Override
    public void makeSound() {
        System.out.println("The Bird sounds: Tweet! Tweet!");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // statement before = is object of the class and 
        // after = is constructor of the class
        Bird bird = new Bird();

        dog.makeSound(); // Output: The Dog sounds: Woof! Woof! coming from child  class method
        dog.sleep();     // Output: The animal is sleeping: Zzz... Zzz... coming from parent clasds method

        bird.makeSound(); // Output: The Bird sounds: Tweet! Tweet!
        bird.sleep();     // Output: The animal is sleeping: Zzz... Zzz...
    }
}