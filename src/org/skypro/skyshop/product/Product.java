package org.skypro.skyshop.product;

import org.skypro.skyshop.interfaces.Searchable;

public abstract class Product implements Searchable {
    protected String name;

    public Product(String name) {
        if ((name == null) || (name.isBlank())) {
            throw new IllegalArgumentException("Ошибка - не введен продукт");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return getName() + " - " + getType();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public abstract boolean isSpecial();

    public abstract String toString();
}

