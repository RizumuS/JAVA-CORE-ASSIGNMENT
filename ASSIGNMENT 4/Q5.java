
import java.util.*;

class CourseEnrollment {

    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {

        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    void displayEnrolledStudents() {

        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseEnrollment enrollment = new CourseEnrollment();

        int choice;

        do {
            System.out.println("\n--- Course Enrollment Menu ---");
            System.out.println("1. Enroll Student");
            System.out.println("2. Display Enrolled Students");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enroll: ");
                    String name = sc.nextLine();

                    enrollment.enrollStudent(name);
                    break;

                case 2:
                    enrollment.displayEnrolledStudents();
                    break;

                case 3:
                    System.out.println("Exiting Course Enrollment System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
