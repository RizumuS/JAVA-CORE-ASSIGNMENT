
import java.util.*;

public class Q5 {

    void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        else {
            System.out.println("Login successful! Welcome " + username);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Q5 user = new Q5();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (username.equalsIgnoreCase("null")) {
            username = null;
        }

        try {
            user.login(username);
        }
        catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
