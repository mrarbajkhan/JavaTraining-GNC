// Create a deserilization program in java to read the object from the file and convert it back to the original object.

// Steps to create Deserilization are:
// step 1) Open file.
// Step 2) Create an Object Stream.
// Step 3) Read Object.
// Step 4) Display Object data.
// Step 5) Close Steams.


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 

class Student implements Serializable {
    String name;
    int id;
    
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

public class SerilizationToDeserilization {
    public static void main(String[] args) {
        try {

            // Part 01: Serialization
            Student student1 = new Student("Arbaj", 101);

            // Step 1: Open file.
           FileOutputStream fos = new FileOutputStream("student.ser");

            // Step 2: Create an Object Stream.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Step 3: Write Object.
            oos.writeObject(student1);
            System.out.println("Object serialized successfully.");

            oos.close();
            fos.close();


            // Part 02: Deserialization

            // Step 1: Open file.
            FileInputStream fis = new FileInputStream("student.ser");

            // Step 2: Create an Object Stream.
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Step 3: Read Object.
            Student student2 = (Student) ois.readObject();

            // Step 4: Display Object data.
            System.out.println("Object deserialized successfully.");
            System.out.println("Student data after deserialization:");

            student2.display();

            // Step 5: Close Steams.
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("File not found: " + e);
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
    }
}


