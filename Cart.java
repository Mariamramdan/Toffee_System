import java.util.*;
import java.util.ArrayList;

public class Cart {
    // List of products in the cart
    private List<Product> products;
    // Total price of products in the cart
    private float total;
    private int cartId;

    //constuctor for the class
    public Cart() {
        products = new ArrayList<Product>();
        total = 0;
        cartId = 0;
    }

    public Cart(int id){
        this.cartId = id;
        products = new ArrayList<Product>();
        total = 0;
    }
    public Cart(Product product , int cartId){
        this.cartId = cartId;
        this.products = products;
    }

    public int getId(){
        return cartId;
    }

    // Add a product to the cart
    public void addProduct(String code , String name , float unitPrice) {
        products.add(new Product(code, name, unitPrice));
        total += unitPrice;
    }

    // Remove a product from the cart
    public void removeProduct(String code , String name , float unitPrice) {
        products.remove(new Product(code, name, unitPrice));
        total -= unitPrice;
    }

    // Get the list of products in the cart
    public List<Product> getProducts() {
        return products;
    }

    // Get the total price of products in the cart
    public float getTotal() {
        return total;
    }

    // Get the number of products in the cart
    public int GetProductCount() {
        return products.size();
    }

    // Empty the cart or ordering it
    public void emptyCart() {
        products.clear();
        total = 0;
    }

    // Display the products that are currently in the cart
    public void displayCart() {
        System.out.println("Products in cart: \n");
        for (Product product : products) {
            System.out.println(product.getName() + " costs " + product.getUnitPrice()+".LE \n");
        }
        System.out.println("Total = " + getTotal()+" .LE");
    }
}
