package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    private ArrayList<Product> basket;
    public ProductBasket() {
        basket = new ArrayList<>();
    }
    public void addProduct(Product product) {
        basket.add(product);
    }
    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        int countSpecial = 0;
        for (Product product : basket) {
            basketPrint.append(product).append("\n");
            if (product.isSpecial()) countSpecial++;
        }
        if (countSpecial != 0) {
            basketPrint.append("Специальных товаров: ").append(countSpecial).append("\n");
        }
        if (basketPrint.isEmpty()) {
            basketPrint.append("В корзине пусто");
        }
        System.out.println(basketPrint);
        String totalPrice1 = String.format("%.2f", totalPrice());
        System.out.println("Итого : < " + totalPrice1 + " > ");
    }
    public double totalPrice() {
        double result = 0.0;
        if (basket.isEmpty()) return 0;
        for (Product product : basket) {
            result += product.getPrice();
        }
        return result;
    }
    public boolean isHasProduct(String name) {
        if (basket.isEmpty()) return false;
        for (Product product : basket) {
            if (product.getName().equals(name)) return true;
        }
        return false;
    }
    public void deleteBasket() {
        basket = new ArrayList<>();
    }
    public List removeProduct(String name) {
        if (basket.isEmpty()) return new ArrayList<Product>();
        ArrayList<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                removedProducts.add(p);
                iterator.remove();
            }
            ;
        }
        return removedProducts;

    }
}
