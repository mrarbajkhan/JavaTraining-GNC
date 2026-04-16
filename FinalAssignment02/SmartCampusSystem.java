// ============================================================
// 🎓 Smart Campus Management System
// ============================================================
//
// 👨‍💻 Developed By: Arbaj
// 📚 Course: Java Final Assessment
// 🏫 Institute: GNC
// 📅 Date: 2026
//
// ------------------------------------------------------------
// 📌 Description:
// This is a console-based Java application designed to manage
// students, courses, and enrollments in a campus system.
//
// The system allows users to:
// - Add students and courses
// - Enroll students into courses
// - View student and enrollment details
// - Store data using MySQL database (JDBC)
// - Save student data into a file
//
// ------------------------------------------------------------
// 🛠️ Technologies Used:
// - Core Java (OOP, Exception Handling)
// - JDBC (Java Database Connectivity)
// - MySQL Database
// - Multithreading
// - File Handling
//
// ------------------------------------------------------------
// ⚙️ Database:
// Database Name: smartcampus
// Tables: students, courses, enrollments
//
// ------------------------------------------------------------
// 🚀 Features:
// ✔ Add Student
// ✔ Add Course
// ✔ Enroll Student
// ✔ View Students
// ✔ View Enrollments
// ✔ MySQL Integration
// ✔ Multithreading Simulation
//
// ------------------------------------------------------------
// 📌 Note:
// Make sure MySQL server is running and database is created
// before executing this program.
//
// ============================================================



import java.io.*;
import java.sql.*;
import java.util.*; 

// Custom Exception
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

// Student Class
class Student {
    int studentId;
    String name;
    String email;

    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Email: " + email;
    }
}

// Course Class
class Course {
    int courseId;
    String courseName;
    double fee;

    public Course(int courseId, String courseName, double fee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "ID: " + courseId + ", Name: " + courseName + ", Fee: " + fee;
    }
}

// Enrollment Processing Thread
class EnrollmentProcessor extends Thread {
    private Student student;
    private Course course;

    public EnrollmentProcessor(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void run() {
        try {
            System.out.println("Processing enrollment for " + student.name + "...");
            Thread.sleep(2000);
            System.out.println("Enrollment completed: " + student.name + " -> " + course.courseName);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

// Main System
public class SmartCampusSystem {

    static Map<Integer, Student> students = new HashMap<>();
    static Map<Integer, Course> courses = new HashMap<>();
    static Map<Integer, List<Course>> enrollments = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // ✅ DB CONNECTION METHOD
    static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/smartcampus";
        String user = "root";
        String pass = "arbaj0318@mysql";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Smart Campus Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Enroll Student");
                System.out.println("4. View Students");
                System.out.println("5. View Enrollments");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: addCourse(); break;
                    case 3: enrollStudent(); break;
                    case 4: viewStudents(); break;
                    case 5: viewEnrollments(); break;
                    case 6: saveData(); System.exit(0);
                    default: throw new InvalidInputException("Invalid choice!");
                }

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input type!");
                sc.nextLine();
            }
        }
    }

    // ✅ ADD STUDENT (DB + MAP)
    static void addStudent() throws InvalidInputException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        students.put(id, new Student(id, name, email));

        try {
            Connection con = getConnection();
            String q = "INSERT INTO students VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        System.out.println("Student added successfully.");
    }

    // ✅ ADD COURSE
    static void addCourse() throws InvalidInputException {
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Fee: ");
        double fee = sc.nextDouble();

        courses.put(id, new Course(id, name, fee));

        try {
            Connection con = getConnection();
            String q = "INSERT INTO courses VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, fee);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        System.out.println("Course added successfully.");
    }

    // ✅ ENROLL STUDENT
    static void enrollStudent() throws InvalidInputException {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        System.out.print("Enter Course ID: ");
        int cid = sc.nextInt();

        enrollments.putIfAbsent(sid, new ArrayList<>());
        enrollments.get(sid).add(courses.get(cid));

        try {
            Connection con = getConnection();
            String q = "INSERT INTO enrollments VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, sid);
            ps.setInt(2, cid);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        EnrollmentProcessor thread = new EnrollmentProcessor(students.get(sid), courses.get(cid));
        thread.start();
    }

    // ✅ VIEW STUDENTS (DB se)
    static void viewStudents() {
        try {
            Connection con = getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("student_id") +
                        ", Name: " + rs.getString("name") +
                        ", Email: " + rs.getString("email"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    // ✅ VIEW ENROLLMENTS (JOIN QUERY)
    static void viewEnrollments() {
        try {
            Connection con = getConnection();

            String q = "SELECT s.name, c.course_name FROM enrollments e " +
                       "JOIN students s ON e.student_id = s.student_id " +
                       "JOIN courses c ON e.course_id = c.course_id";

            ResultSet rs = con.createStatement().executeQuery(q);

            while (rs.next()) {
                System.out.println(rs.getString("name") + " -> " + rs.getString("course_name"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    // File Handling
    static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students.values()) {
                writer.println(s.studentId + "," + s.name + "," + s.email);
            }
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}