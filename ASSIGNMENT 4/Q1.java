
import java.util.*;

class Library {

    ArrayList<String> books = new ArrayList<>();

    void addBook(String title) {
        books.add(title);
        System.out.println("Book added successfully.");
    }

    void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Current Books:");

            for (String book : books) {
                System.out.println(book);
            }
        }
    }
}

public class Q1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String addTitle = sc.nextLine();

                    library.addBook(addTitle);
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = sc.nextLine();

                    library.removeBook(removeTitle);
                    library.displayBooks();
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
