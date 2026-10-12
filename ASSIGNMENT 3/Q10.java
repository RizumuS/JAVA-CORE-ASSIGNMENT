
import java.util.*;

class BankTransaction extends Thread {
    int amount;

    BankTransaction(int amount, String name) {
        this.amount = amount;
        setName(name);
    }

    public void run() {
        if (amount >= 50000) {
            System.out.println("High-value transaction processed first");
        }
        else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class Q10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Transaction1 amount: ");
        int amount1 = sc.nextInt();

        System.out.print("Enter Transaction2 amount: ");
        int amount2 = sc.nextInt();

        BankTransaction t1 = new BankTransaction(amount1, "Transaction1");
        BankTransaction t2 = new BankTransaction(amount2, "Transaction2");

        if (amount1 >= 50000) {
            t1.setPriority(Thread.MAX_PRIORITY);
        }
        else {
            t1.setPriority(Thread.MIN_PRIORITY);
        }

        if (amount2 >= 50000) {
            t2.setPriority(Thread.MAX_PRIORITY);
        }
        else {
            t2.setPriority(Thread.MIN_PRIORITY);
        }

        t1.start();
        t2.start();

        sc.close();
    }
}
