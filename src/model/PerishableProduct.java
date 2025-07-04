package model;

public class PerishableProduct extends Product {
    public PerishableProduct(String name, double price, int quantity) {
        super(name, price, quantity); // no duplicate code => use the inherited constructor
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return 0; // no weight unless i decide to add the weight
    }
}
