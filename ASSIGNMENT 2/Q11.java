import java.util.*;

class Room
{
    private String roomNumber;
    private String block;
    private String type;

    public Room (String roomNumber, String block, String type){
        this.roomNumber = roomNumber;
        this.block = block;
        this.type = type;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public String getBlock() {
        return block;
    }

    public String getType() {
        return type;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Student
{
    private String name;
    private int roll;
    private String course;
    private Room room;

    public Student(String name, int roll, String course, Room room) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public String getCourse() {
        return course;
    }

    public Room getRoom() {
        return room;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override 
    public String toString() {
        return "Student: " + name + " (" + roll + ") " + course + "\nRoom: " + room.getRoomNumber() + " " + room.getBlock() + " " + room.getType();
    }
}

public class Q11 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name, roll number, course, room number, block and room type: ");
        String name = sc.nextLine();
        int roll = Integer.parseInt(sc.nextLine());
        String course = sc.nextLine();
        String roomNumber = sc.nextLine();
        String block = sc.nextLine();
        String type = sc.nextLine();

        Room room = new Room(roomNumber, block, type);
        Student student = new Student(name, roll, course, room);
        System.out.println(student);
        sc.close();
    }
}
