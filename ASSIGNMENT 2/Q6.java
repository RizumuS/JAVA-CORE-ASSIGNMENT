import java.util.*;

class Author
{
    String name, email, gender;

    public Author(String name, String email, String gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String toString(){
        return "Name: " + name + " Email: " + email + "Gender: " + gender;
    }
}

class Book extends Author{
    String title, author;
    int price;

    public Book(String name, String email, String gender, String title, int price){
        super(name, email, gender);
        this.title = title;
        this.price = price;
    }

    @Override 
    public String toString(){
        return "Book: " + title + "\nPrice: " + price + "\nAuthor: " + name + " " + gender +  "\nEmail: " + email;
    }
}

public class Q6 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book name, price, author name, email and gender: ");
        String n = sc.nextLine();
        int p = sc.nextInt();
        String a = sc.nextLine();
        String e = sc.next();
        String g = sc.next();
        
        Book b1 = new Book(a, e, g, n, p);
        System.out.println(b1);
        
        sc.close();

    }
    
}
