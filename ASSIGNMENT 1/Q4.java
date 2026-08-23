import java.util.*;
public class Q4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Are you a citizen? (true/false): ");
        boolean citizen = sc.nextBoolean();

        if(age>= 18 && citizen){
            System.out.println("you are eligible to vote.");
        }
        sc.close();
    }
    
}
