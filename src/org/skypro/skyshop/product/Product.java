package org.skypro.skyshop.product;

public abstract class Product {
    protected String name;
    public Product(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract double getPrice();
    public abstract boolean isSpecial();
    public abstract String toString();
}

