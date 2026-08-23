public class Q7 {
    public static void main(String[] args){
        int num = 1;
        int sum = 0;

        while(num <= 50){
            if(num % 2 == 0){
                sum = sum + num;
            }
            num++;
        }

        System.out.println("Sum of even numbers from 1 to 50 is: " + sum);
    }
}