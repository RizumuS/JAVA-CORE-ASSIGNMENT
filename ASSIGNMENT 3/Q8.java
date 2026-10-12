import java.util.*;

class PrinterJob implements Runnable {
    private int jobNumber;
    private String studentName;

    PrinterJob(int jobNumber, String studentName) {
        this.jobNumber = jobNumber;
        this.studentName = studentName;
    }

    public void run() {
        try {
            System.out.println("Printing job " + jobNumber + " by " + studentName);

            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("Printing interrupted.");
        }
    }
}

public class Q8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Number of print jobs: ");
        int numberOfJobs = sc.nextInt();

        for (int i = 1; i <= numberOfJobs; i++) {

            String studentName = "Student " + (char)('A' + i - 1);

            PrinterJob job = new PrinterJob(i, studentName);

            Thread thread = new Thread(job);
            thread.start();
        }

        sc.close();
    }
}