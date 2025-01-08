package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Коктель", 89.0);
        SimpleProduct product2 = new SimpleProduct("Роллы", 560.);
        DiscountedProduct product3 = new DiscountedProduct("Пицца", 658.,20);
        DiscountedProduct product4 = new DiscountedProduct("Картофель", 278.0,18);
        FixPriceProduct product5 = new FixPriceProduct("Кола");
        SimpleProduct product6 = new SimpleProduct("Напиток", 45);

        ProductBasket basket = new ProductBasket();
        basket.addProduct1(product1);
        basket.addProduct1(product2);
        basket.addProduct1(product3);
        basket.addProduct1(product4);
        basket.addProduct1(product5);
        basket.addProduct1(product6);

        basket.printBasket5();
        System.out.println(basket.isHasProduct("Кола"));
        System.out.println(basket.isHasProduct("Десерт"));

        basket.deleteBasket();
        basket.printBasket5();



        System.out.println(basket.isHasProduct("Десерт"));
    }
}


