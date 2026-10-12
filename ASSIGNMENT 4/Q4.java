
import java.util.*;

class Inventory {

    HashMap<Integer, Integer> products = new HashMap<>();

    // Method to add a product
    void addProduct(int productID, int stock) {

        products.put(productID, stock);

        System.out.println("Product " + productID
                + " added with stock " + stock);
    }

    void updateStock(int productID, int stock) {

        if (products.containsKey(productID)) {
            products.put(productID, stock);

            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\nCurrent Inventory:");

            Iterator<Map.Entry<Integer, Integer>> itr =
                    products.entrySet().iterator();

            while (itr.hasNext()) {

                Map.Entry<Integer, Integer> entry = itr.next();

                System.out.println("Product ID: " + entry.getKey()
                        + " -> Stock: " + entry.getValue());
            }
        }
    }
}

public class Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    inventory.addProduct(id, stock);
                    break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int updateID = sc.nextInt();

                    System.out.print("Enter New Stock: ");
                    int newStock = sc.nextInt();

                    inventory.updateStock(updateID, newStock);
                    break;

                case 3:
                    inventory.displayInventory();
                    break;

                case 4:
                    System.out.println("Exiting Inventory System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
