
import java.util.*;

class Attendance {

    HashSet<String> students = new HashSet<>();

    void markAttendance(String name) {

        if (students.add(name)) {
            System.out.println("Attendance marked for " + name);
        } else {
            System.out.println(name + " is already marked present");
        }
    }

    void displayAttendance() {

        System.out.println("\nPresent Students:");

        if (students.isEmpty()) {
            System.out.println("No students marked present.");
        } else {
            for (String name : students) {
                System.out.println(name);
            }
        }
    }
}

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        int choice;

        do {
            System.out.println("\n--- Attendance Menu ---");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name to mark attendance: ");
                    String name = sc.nextLine();

                    attendance.markAttendance(name);
                    break;

                case 2:
                    attendance.displayAttendance();
                    break;

                case 3:
                    System.out.println("Exiting Attendance System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
