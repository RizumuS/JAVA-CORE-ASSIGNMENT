import java.util.*;
public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Temperature in Celsius: ");
        int celcius = sc.nextInt();
        int fahrenheit = (celcius * 9/5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
        sc.close();

    }
    
}
