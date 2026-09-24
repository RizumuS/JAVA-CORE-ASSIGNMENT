import java.util.Scanner;

class Account {
    private double balance;

    Account() {
        balance = 0;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    double getBalance() {
        return balance;
    }
}

public class Q14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account account = new Account();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String operation = sc.nextLine();

            if (operation.startsWith("deposit")) {
                double amount = Double.parseDouble(
                    operation.substring(7).trim()
                );
                account.deposit(amount);

            } else if (operation.startsWith("withdraw")) {
                double amount = Double.parseDouble(
                    operation.substring(8).trim()
                );
                account.withdraw(amount);

            } else if (operation.equals("getBalance")) {
                System.out.println("Balance: " + account.getBalance());
            }
        }

        sc.close();
    }
}