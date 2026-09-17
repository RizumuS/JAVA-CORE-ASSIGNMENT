import java.util.*;

class Person
{
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override 
    public String toString(){
        return "Name: " + name + "\nAge: " + age;

    }

}

class Doctor extends Person{
    String specialization;

    public Doctor(String name, int age, String specialization){
        super(name, age);
        this.specialization = specialization;
    }

    @Override 
    public String toString(){
        return "Name: " + name + "\nAge: " + age + "\nSpecialization: " + specialization;

    }
}

class Surgeon extends Doctor{
    String surgeryType;

    public Surgeon(String name, int age, String specialization, String surgeryType){
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    @Override 
    public String toString(){
        return "Name: " + name + "\nAge: " + age + "\nSpecialization: " + specialization + "\nSurgery Type: " + surgeryType;

    }

}


public class Q5 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name, age, specialization and Surgery Type: ");
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String sz = sc.nextLine();
        String st = sc.nextLine();

        Surgeon sn = new Surgeon(name, age, sz, st);
        System.out.println(sn);
        sc.close();
    }
    
}
