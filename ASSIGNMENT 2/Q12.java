import java.util.*;

class Vehicle {
    String regNo, brand;
    float baseRate;

    public Vehicle(String regNo, String brand, float baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }
}

class Car extends Vehicle {
    public Car(String regNo, String brand, float baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override 
    public String toString() {
        return "Car " + regNo + " " + brand + " Rent: " + (baseRate*1.5);
    }
}

class Bike extends Vehicle {
    public Bike(String regNo, String brand, float baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override 
    public String toString() {
        return "Bike " + regNo + " " + brand + " Rent: " + (baseRate*1.2);
    }
}

public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car registration number, brand and rate: ");
        String regNo = sc.nextLine();
        String brand = sc.nextLine();
        float rate = Integer.parseInt(sc.nextLine());

        System.out.print("Enter bike registration number, brand and rate: ");
        String regNo1 = sc.nextLine();
        String brand1 = sc.nextLine();
        float rate1 = Integer.parseInt(sc.nextLine());

        Car c1 = new Car(regNo, brand, rate);
        Bike b1 = new Bike(regNo1, brand1, rate1);

        System.out.println(c1);
        System.out.println(b1);

        sc.close();
    }
    
}
