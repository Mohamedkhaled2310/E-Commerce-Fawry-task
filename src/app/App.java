package app;
import model.*;
import service.Checkout;

public class App {
    public static void main(String[] args) throws Exception {
        Product cheese = new ShippingProduct("Cheese", 100, 10, 0.4);
        Product biscuits = new PerishableProduct("Biscuits", 50, 10);
        Product mobile = new NonPerishableProduct("Mobile", 200, 10);

        Customer customer = new Customer("John Doe", 500);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(mobile, 1);

        Checkout.processCheckout(customer, cart);
    }
}
