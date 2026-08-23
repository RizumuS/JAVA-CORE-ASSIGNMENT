import java.util.*;
public class Q9 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] num = new int[10];

        for(int i = 0; i<10; i++){
            System.out.print("Enter number " + (i+1) + ": ");
            num[i] = sc.nextInt();
        }

        int max = num[0];

        for(int i = 1; i<10; i++){
            if(num[i]>max){
                max = num[i];
            }
        }
        System.out.println("Maximum value: " + max);
        
        sc.close();
        }
    }