import java.util.*;
public class Q10 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[5];
        int sum = 0;

        for (int i = 0; i<5; i++){
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            sum = sum + marks[i];
        }

        double average = sum/5.0;

        String grade;

        if(average>=90){
            grade = "A";
        } else if (average>= 75){
            grade = "B";
        } else if (average >= 50){
            grade = "C";
        } else {
            grade = "Fail";
        }

        System.out.println("\nTotal Marks: " + sum);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);

        sc.close();
        }
        }