
import java.util.*;

class TicketBooking {
    int availableSeats;

    TicketBooking(int seats) {
        availableSeats = seats;
    }

    synchronized void bookSeat(int seats) {
        String userName = Thread.currentThread().getName();

        if (availableSeats >= seats) {
            System.out.println(userName + " booked " + seats + " seat(s) successfully");
            availableSeats -= seats;
        }
        else {
            System.out.println(userName + " booking failed. Not enough seats");
        }
    }
}

class User1 extends Thread {
    TicketBooking booking;
    int seats;

    User1(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
        setName("User1");
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

class User2 extends Thread {
    TicketBooking booking;
    int seats;

    User2(TicketBooking booking, int seats) {
        this.booking = booking;
        this.seats = seats;
        setName("User2");
    }

    public void run() {
        booking.bookSeat(seats);
    }
}

public class Q7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Available Seats: ");
        int availableSeats = sc.nextInt();

        System.out.print("User1 wants to book: ");
        int seats1 = sc.nextInt();

        System.out.print("User2 wants to book: ");
        int seats2 = sc.nextInt();

        TicketBooking booking = new TicketBooking(availableSeats);

        User1 u1 = new User1(booking, seats1);
        User2 u2 = new User2(booking, seats2);

        u1.start();
        u2.start();

        sc.close();
    }
}
