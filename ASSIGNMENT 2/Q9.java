import java.util.*;

abstract class Course{
    String courseName;
    int duration;

    public Course(String courseName, int duration){
        this.courseName = courseName;
        this.duration = duration;
    }
}

class Student extends Course{
    String name;

    public Student(String courseName, int duration, String name){
        super(courseName, duration);
        this.name = name;
    }

    @Override 
    public String toString(){
        return "Student: " + name + "Course: " + courseName + "(" + duration + " months)";
    }
}

class PremiumStudent extends Student{
    int discount;

     public PremiumStudent(String courseName, int duration, String name, int discount){
        super(courseName, duration, name);
        this.discount = discount;
    }

    @Override 
    public String toString(){
        return "Student: " + name + "Course: " + courseName + "(" + duration + " months) Discount: " + discount + "%";
    }
}

public class Q9 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course, duration, name: ");
        String c = sc.nextLine();
        int d = Integer.parseInt(sc.nextLine());
        String name = sc.nextLine();

        System.out.print("Enter course, duration, name, discount: ");
        String c1 = sc.nextLine();
        int d1 = Integer.parseInt(sc.nextLine());
        String name1 = sc.nextLine();
        int d2 = Integer.parseInt(sc.nextLine());

        Student st1 = new Student(c, d, name);
        PremiumStudent st2 = new PremiumStudent(c1, d1, name1, d2);

        System.out.println(st1);
        System.out.println(st2);

        sc.close();
    }
    
}
