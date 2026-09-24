import java.util.*;

class Guest {
    String name, id;
    int age;

    public Guest(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String toString() {
        return name + ", " + age + ", " + id;
    }
}

class Reservation {
    String rid, roomType;
    List<Guest> guests;

    public Reservation(String rid, String roomType) {
        this.rid = rid;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    void addGuest(Guest guest) {
        guests.add(guest);
    }

    @Override 
    public String toString() {
        String result = "Reservation ID: " + rid + " Room: " + roomType + "\n";

        result += "Guests:\n";
        for(Guest guest: guests){
            result += guest + "\n";
        }

        return result;
        
    }
}

public class Q13 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter reservation ID, room type and number of guests: ");
        String rid = sc.nextLine();
        String roomType = sc.nextLine();
        int number = Integer.parseInt(sc.nextLine());

        Reservation r1 = new Reservation(rid, roomType);

        for (int i = 0; i<number; i++) {
            System.out.print("Enter guest details: ");
            String name = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            String id = sc.nextLine();
            Guest guest = new Guest(name, age, id);
            r1.addGuest(guest);
        }

        System.out.println(r1);

        sc.close();
    }
    
}
