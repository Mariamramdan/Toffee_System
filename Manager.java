import java.util.ArrayList;
import java.util.Hashtable;

public class Manager {
    private static ArrayList<Product> ArrayOfProducts = new ArrayList<Product>();
    private static ArrayList<Order>  ArrayOforders = new ArrayList<Order>();
    private static ArrayList<Cart> arrayOfCarts = new ArrayList<Cart>();
    private int orderIDGenerator;
    private int cartIDGenerator;
    
    static{
        ArrayOfProducts.add(new Product("xx1 ", "Cupcake   ", 30));
        ArrayOfProducts.add(new Product("xx2 ", "Cake      ", 200));
        ArrayOfProducts.add(new Product("xx3 ", "Cinnabon  ", 100));
        ArrayOfProducts.add(new Product("xx4 ", "Brownies  ", 70));
        ArrayOfProducts.add(new Product("xx5 ", "Biscuit   ", 45));
        ArrayOfProducts.add(new Product("xx6 ", "Croissant ", 50));
        ArrayOfProducts.add(new Product("xx7 ", "Kunafa    ", 175));
        ArrayOfProducts.add(new Product("xx8 ", "basbousa  ", 175));
        ArrayOfProducts.add(new Product("xx9 ", "harissa   ", 150));
        ArrayOfProducts.add(new Product("x10 ", "Chocolate ", 300));

    }

    public Manager(){
        System.out.println("\t\t\t\t<<Welcome to Toffee Store>>");
        System.out.println("");
    }
    //  Add new product to Store
    public void AddToStore(Product product){
        ArrayOfProducts.add(product);
    }
    //  Search by product code in Catalog
    private Product searchInCatalog(String productCode){
        Product newProduct = new Product();
        for(Product i :ArrayOfProducts){
            if(i.getCode().equals(productCode)){
                newProduct = i;
            }
        }
        return newProduct;
    } 
    //  Search
    public void search(String code){
        if (searchInCatalog(code).getName() != null){
            System.out.println("\tAfter searching for this code " + "{ " + searchInCatalog(code).getCode() + "} ..." );
            System.out.println("\tProduct Name and Unit price: [ " + searchInCatalog(code).getName() + "- "+ searchInCatalog(code).getUnitPrice() + " .LE ]");
            System.out.println("----------------------------------------------");
        }
        else if (searchInCatalog(code) != null){
            System.out.println("This Item not Found");
            System.out.println("----------------------------------------------");
        }
    }

    //  Display Catalog
    public void viewCatalog(){
        System.out.println("\t<<Toffee Catalog>>");
        System.out.println("");
        for(Product product :ArrayOfProducts){
            System.out.println("\t" +product.getName() + " " +product.getCode() +" " +product.getUnitPrice());
        }
        System.out.println("----------------------------------------------");
    }
    //  Remove from store and catalog 
    public void removeProduct(String Pcode){
        Product del = searchInCatalog(Pcode);
        if(del != null){
            ArrayOfProducts.remove(del);
            System.out.println("The item has been removed");
        }
        else
            System.out.println("This item is not found in the catalog");
    }
    //  Add a new item to an order.
    public void addProductToOrder (int orderID, String productCode, int quantity) { 
        Order order = getOrder(orderID);
        order.addOrderDetail(searchInCatalog(productCode), quantity);
    }
    //  Create a new order and return the ID of the newly created order
    public int createOrder (float taxPercentage, String deliveryAddress) {  
        ++orderIDGenerator;
        Order order = new Order(taxPercentage , deliveryAddress , orderIDGenerator);
        ArrayOforders.add(order);
        return orderIDGenerator;
    }
    //  Accessor method for order
    public Order getOrder(int orderID){
        Order newOrder = new Order();
        for(Order i :ArrayOforders){
            if(i.getOrderID() == orderID){
                newOrder = i;
                break;
            }
        }
        return newOrder; 
    }
    //  Accessor method for cart
    public Cart getCart(int cartId){
        Cart newCart = new Cart();
        for (Cart i : arrayOfCarts){
            if(i.getId() == cartId){
                newCart = i;
                break;
            }
        }
        return newCart;
    }
    
    // Cart
    public void AddToCart(int cartID, String productCode, int quantity){
        Cart cart = getCart(cartID);
        cart.addProduct(productCode, productCode, quantity);
    }
    //  Create a new order and return the ID of the newly created order
    public int openCart (int ID) {  
        ++cartIDGenerator;
        Cart cart = new Cart(ID);
        arrayOfCarts.add(cart);
        return cartIDGenerator;
    }
    // Delete Item from cart

    // Payment
    public void payOrder(Payment payment ,Order order){
        order.payOrder(payment);
    }


    
}
