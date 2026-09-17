import java.util.*;

abstract class Loan{
    double principle, time;

    public Loan(double principle, double time){
        this.principle = principle;
        this.time = time;
    }
    abstract double calculateInterest();
}

class HomeLoan extends Loan{
    double rate = 8;

    public HomeLoan(double principle, double time){
        super(principle, time);
    }

    double calculateInterest(){
        return (principle*rate*time)/100;
    }
}

class CarLoan extends Loan{
    double rate = 10;

    public CarLoan(double principle, double time){
        super(principle, time);
    }

    double calculateInterest(){
        return (principle*rate*time)/100;
    }
}

public class Q8 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Loan Type, amount and time: ");
        String lt = sc.nextLine();
        double a = Double.parseDouble(sc.nextLine());
        double t = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Loan Type, amount and time: ");
        String lt1 = sc.nextLine();
        double a1 = Double.parseDouble(sc.nextLine());
        double t1 = Double.parseDouble(sc.nextLine());

        HomeLoan hl = new HomeLoan(a, t);
        CarLoan cl = new CarLoan(a1, t1);

        System.out.println("Home Loan Interest: " + hl.calculateInterest());
        System.out.println("Car Loan Interest: " + cl.calculateInterest());

        sc.close();
    }
    
}
