import java.util.*;
public class Q8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];

        for (int i = 0; i<5; i++){
            System.out.print("Enter marks of student " + (i+1) + ": ");
            marks[i] = sc.nextInt();
        }

        System.out.print("\nStudent Marks: ");

        for(int i = 0; i<5; i++){
            System.out.println("Student " + (i+1) + ": " + marks[i]);
        }
        sc.close();
    }
}
