package service;

import app.Cart;
import app.Customer;
import model.CartItem;
import model.Shippable;
import java.util.List;
import java.util.ArrayList;

public class Checkout {
    public static void processCheckout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) {
                System.out.println("Error: " + item.getProduct().getName() + " is expired");
                return;
            }
        }

        double subtotal = cart.calculateSubtotal();
        double shippingFees = cart.calculateShippingFees();
        double totalAmount = subtotal + shippingFees;

        if (!customer.canAfford(totalAmount)) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((Shippable) item.getProduct());
                }
            }
        }

        if (!shippables.isEmpty()) {
            ShippingService.processShipping(shippables);
        }

        customer.pay(totalAmount);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s    %.2f\n", item.getQuantity(), item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Shipping: %.2f\n", shippingFees);
        System.out.printf("Amount: %.2f\n", totalAmount);
        System.out.printf("Customer balance after payment: %.2f\n", customer.getBalance());
    }
}
