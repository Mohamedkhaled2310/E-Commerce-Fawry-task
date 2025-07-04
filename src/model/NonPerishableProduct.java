package model;

public class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, quantity); // no duplicate code => use the inherited constructor
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}

