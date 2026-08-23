import java.util.*;
public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Table of " + num + " is: ");
        for(int i=1; i<=10; i++){
            System.out.println(i + " * " + num + " = " + (i*num));
        }
        sc.close();
    }
}
