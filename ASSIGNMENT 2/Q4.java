import java.util.*;

class Product 
{
    String productName;
    int price, quantity;

    Product(String productName, int price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String toString(){
        return productName + " x" + quantity + " = " + (price*quantity);

    }

}

class Order
{
    String orderID;
    List<Product> products;

    public Order(String orderID){
        this.orderID = orderID;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }


    int calculateTotal()
    {
        int total = 0;

        for(Product product : products){
            total += product.getPrice() * product.getQuantity();
        }

        return total;

    }

    @Override
    public String toString() {
        String result = "Order ID: " + orderID + "\n";
        result += "Products:\n";

        for(Product product : products){
            result += product + "\n";
        }

        result += "Total: " + calculateTotal();

        return result;
    }
}

public class Q4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Order ID: ");
        String orderID = sc.nextLine();
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        Order order = new Order(orderID);

        for(int i = 0; i<n; i++){
            System.out.print("Enter Name, amount and quantitiy: ");
            String productName = sc.next();
            int price = sc.nextInt();
            int quantity = sc.nextInt();

            Product product = new Product(productName, price, quantity);
            order.addProduct(product);
        }

        System.out.println(order);
        sc.close();
    }
    
}
