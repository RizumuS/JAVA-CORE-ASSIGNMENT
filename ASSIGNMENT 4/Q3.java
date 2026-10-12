
import java.util.HashMap;
import java.util.Scanner;

class BankDirectory {

    HashMap<Integer, String> accounts = new HashMap<>();

    // Method to add an account
    void addAccount(int accountNo, String customerName) {

        accounts.put(accountNo, customerName);
        System.out.println("Account added successfully.");
    }

    // Method to retrieve customer name
    void getCustomer(int accountNo) {

        if (accounts.containsKey(accountNo)) {
            System.out.println("Customer Name: " + accounts.get(accountNo));
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to display all accounts
    void displayAll() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            System.out.println("\nAll Bank Accounts:");

            for (Integer accountNo : accounts.keySet()) {
                System.out.println("Account No: " + accountNo
                        + " -> " + accounts.get(accountNo));
            }
        }
    }
}

public class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankDirectory bank = new BankDirectory();

        int choice;

        do {
            System.out.println("\n--- Bank Directory Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account No: ");
                    int accountNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();

                    bank.addAccount(accountNo, name);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int searchNo = sc.nextInt();

                    bank.getCustomer(searchNo);
                    break;

                case 3:
                    bank.displayAll();
                    break;

                case 4:
                    System.out.println("Exiting Bank Directory.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
