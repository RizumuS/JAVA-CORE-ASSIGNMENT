import java.util.*;

class ATM {
    double balance;

    ATM(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        if(amount>balance) {
            throw new ArithmeticException("Insufficient Balance");
        }

        balance = balance - amount;
        System.out.println("Withdrawal Successful");
        System.out.println("Remaining Balance: " + balance);

    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter balance: ");
        double bal = sc.nextDouble();
        System.out.print("Enter amount to withdraw: ");
        double am = sc.nextDouble();

        ATM atm1 = new ATM(bal);
        try {
            atm1.withdraw(am);
        }
        catch (ArithmeticException e) {
            System.out.println("Exception : " + e.getMessage());
        }
        finally {
            System.out.println("Transaction Completed");
        }

        sc.close();
    }
}