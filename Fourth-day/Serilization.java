// write a program to saving an object to a file using serialization in java.

// Serialization : It means converting an object into a byte stream, which can be saved to a file or transmitted over a network.
/*  Deserilization : it means reading the object from the file and converting it back to the original object. 
                     We can use ObjectInputStream to read the object from the file and cast it back to the original type. */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Step 1: Student class must implement Serializable.
class Student implements Serializable {
    String name;
    int id;
    
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class Serilization {
    public static void main(String[] args) {
        try {
            // Step 2: Create a student object to be serialized.
            Student student1 = new Student("Arbaj", 101);

            // Step 3: Create a fileOutputStream.
            FileOutputStream fos = new FileOutputStream("student.ser");

            // Step 4: Create an ObjectOutputStream to write the object to the file.
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(student1);
            // Step 5: Close the streams.
            out.close();
            fos.close();

            // Step 6: Print a success message.
            System.out.println("Serialized data is saved Successfully in student.ser");

            // Note: The file "student.ser" will be created in the current working directory of the program.
            // You can change the path in the FileOutputStream constructor to save it in a different location.
            // For example: FileOutputStream fos = new FileOutputStream("C:/path/to/your/directory/student.ser");
        } catch (IOException e) {
            System.out.println("An error occurred during serialization: " + e.getMessage());
        }
    }
}

