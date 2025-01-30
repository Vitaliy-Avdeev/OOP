package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket;

    public ProductBasket() {
        basket = new HashMap<>();
    }

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), _ -> new ArrayList<>()).add(product);
    }

    public void printBasket() {
        StringBuilder basketPrint = new StringBuilder();
        basket.values().stream().flatMap(Collection::stream).forEach(product -> basketPrint.append(product).append("\n"));
        int countSpecial = (int) basket.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();

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
        return basket.values().stream().flatMap(Collection::stream).mapToDouble(Product::getPrice).sum();
    }

    public boolean isHasProduct(String name) {
        if (basket.isEmpty()) return false;
        return basket.containsKey(name);
    }

    public void deleteBasket() {
        basket.clear();
    }

    public List removeProduct(String name) {
        if (basket.isEmpty() || !basket.containsKey(name)) return new ArrayList<Product>();
        return basket.remove(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(basket, that.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(basket);
    }
}
