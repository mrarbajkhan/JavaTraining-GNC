
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class Student {
    String name;
    int id;
    
    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

public class FileCreate {
    public static void main(String[] args) {
        Student student1 = new Student("Arbaj", 10021);
        Student student2 = new Student("Raj Sharma", 22001);
    
        // Writing to a file using BufferedWriter and FileWriter.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            writer.write(student1.name + "," + student1.id);
            writer.newLine();
            writer.write(student2.name + "," + student2.id);
            System.out.println("Students written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        
        // Reading from a file
        try (FileReader reader = new FileReader("students.txt")) {
            int character;
            System.out.println("Contents of the file:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
        }
    }
}