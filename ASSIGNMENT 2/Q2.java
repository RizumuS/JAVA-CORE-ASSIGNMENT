import java.util.*;

abstract class Flight {
    private String flightNumber, airline;
    private double fare;

    Flight(String flightNumber, String airline, double fare) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.fare = fare;
    }

    abstract double calculateFare();

    double baseFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Airline: " + airline + ", Fare: " + calculateFare();
    }
}

class DomesticFlight extends Flight {
    DomesticFlight(String flightNumber, String airline, double fare) {
    super(flightNumber, airline, fare);
}
    double calculateFare() {
        return baseFare() * 1.10;
    }
}

class InternationalFlight extends Flight {

    InternationalFlight(String flightNumber, String airline, double fare) {
        super(flightNumber, airline, fare);
    }
    double calculateFare() {
        return baseFare() * 1.25;
    }
}

public class Q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        String flightNumber = sc.nextLine();
        System.out.print("Enter airline: ");
        String airline = sc.nextLine();
        System.out.print("Enter fare: ");
        double fare = sc.nextDouble();
        System.out.print("Enter flight type (domestic/international): ");
        String flightType = sc.next();

        Flight flight;
        if (flightType.equalsIgnoreCase("domestic")) {
            flight = new DomesticFlight(flightNumber, airline, fare);
        } else {
            flight = new InternationalFlight(flightNumber, airline, fare);
        }

        System.out.println(flight);
        sc.close();
    }
}
