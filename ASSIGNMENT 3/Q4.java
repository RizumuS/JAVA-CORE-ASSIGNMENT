
import java.util.*;

class InvalidMarksException extends Exception {
    InvalidMarksException(String message) {
        super(message);
    }
}

public class Q4 {

    void enterMarks(int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        } 
        else {
            System.out.println("Marks entered successfully: " + marks);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Q4 student = new Q4();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        try {
            student.enterMarks(marks);
        }
        catch (InvalidMarksException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        finally {
            System.out.println("Thank you for using the system");
        }

        sc.close();
    }
}
