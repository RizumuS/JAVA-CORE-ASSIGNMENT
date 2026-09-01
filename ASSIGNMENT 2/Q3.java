import java.util.*;

class Employee {
    String name, id;
    double basicSalary;

    Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;

    }

    double calculateSalary() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return "Employee Name: " + name + ", ID: " + id + ", Salary: " + calculateSalary();
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, String id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    double calculateSalary() {
        return basicSalary + bonus;
    }
}

public class Q3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Employee or Manager? (e/m): ");
        String choice = sc.nextLine();
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter basic salary: ");
        double basicSalary = sc.nextDouble();

        if (choice.equalsIgnoreCase("m")){
             System.out.print("Enter bonus: ");
             double bonus = sc.nextDouble();
             Manager mgr = new Manager(name, id, basicSalary, bonus);
             System.out.println(mgr);
        }
        else {
             Employee emp = new Employee(name, id, basicSalary);
             System.out.println(emp);
        }

        sc.close();
    }
}
