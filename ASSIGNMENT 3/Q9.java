
import java.util.*;

class SquareCalculator extends Thread {
    int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

class RandomNumberGenerator extends Thread {
    private volatile boolean running = true;
    Random random = new Random();

    public void stopGeneration() {
        running = false;
        interrupt();
    }

    public void run() {
        while (running) {
            int number = random.nextInt(10) + 1;

            System.out.println("Generated: " + number);

            try {
                Thread calculator;

                if (number % 2 == 0) {
                    calculator = new SquareCalculator(number);
                }
                else {
                    calculator = new CubeCalculator(number);
                }

                calculator.start();

                calculator.join();

                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                if (!running) {
                    break;
                }
            }
        }
    }
}

public class Q9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RandomNumberGenerator generator = null;

        while (true) {
            System.out.println("\n----- IoT Sensor Menu -----");
            System.out.println("1. Start Simulation");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (generator == null || !generator.isAlive()) {
                        generator = new RandomNumberGenerator();
                        generator.start();
                    }
                    else {
                        System.out.println("Simulation is already running.");
                    }
                    break;

                case 2:
                    if (generator != null && generator.isAlive()) {
                        generator.stopGeneration();

                        try {
                            generator.join();
                        }
                        catch (InterruptedException e) {
                            System.out.println("Simulation interrupted.");
                        }
                    }

                    System.out.println("Exiting IoT Sensor Simulation.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
