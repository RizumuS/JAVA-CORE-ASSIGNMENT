import java.util.*;
public class Q5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.print("Enter operator: ");
        String op = sc.next();

        if(op.equals("+")){
            System.out.println("Sum: " + (num1+num2));
        }
        else if(op.equals("-")){
            System.out.println("Difference: " + (num1-num2));
        }
        else if(op.equals("*")){
            System.out.println("Product: " + (num1*num2));
        }
        else if(op.equals("/")){
            System.out.println("Division: " + (num1/num2));
        }
        sc.close();
    }
}
