
import java.util.*;

class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class Student {
    String name;

    // Method to register student
    void registerStudent(int age) throws InvalidAgeException {
        if (age < 17) {
            throw new InvalidAgeException("Age must be above 17 for registration");
        } else {
            System.out.println("Student registered successfully!");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s = new Student();

        System.out.print("Enter name: ");
        s.name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        try {
            s.registerStudent(age);
        } 
        catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
