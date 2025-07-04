package model;
public abstract class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean expired;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = false;
    }

    public abstract boolean requiresShipping();
    public abstract double getWeight();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
