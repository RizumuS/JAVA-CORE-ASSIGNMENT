
import java.util.*;

// User-defined exception
class MinimumAmountException extends Exception {
    MinimumAmountException(String message) {
        super(message);
    }
}

// OnlineShopping class
public class Q6 {

    // Method to place an order
    void placeOrder(int amount) throws MinimumAmountException {
        if (amount < 500) {
            throw new MinimumAmountException("Minimum cart value must be Rs.500");
        }
        else {
            System.out.println("Order placed successfully!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Q6 shop = new Q6();

        System.out.print("Enter cart amount: ");
        int amount = sc.nextInt();

        try {
            shop.placeOrder(amount);
        }
        catch (MinimumAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
