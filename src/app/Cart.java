package app;

import model.CartItem;
import model.Product;
import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be positive");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Error: Not enough stock for " + product.getName());
            return;
        }

        product.reduceQuantity(quantity);
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }

    public double calculateShippingFees() {
        double totalWeight = 0;
        for (CartItem item : items) {
            if (item.getProduct().requiresShipping()) {
                totalWeight += item.getProduct().getWeight() * item.getQuantity();
            }
        }
        // example shipping fee calculation => 10 per kg
        return totalWeight * 10;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
