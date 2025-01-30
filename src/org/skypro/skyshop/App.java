package org.skypro.skyshop;

import java.util.*;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

public class App {
    public App() {
    }
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Коктель", (double) 80.0F);
        SimpleProduct product2 = new SimpleProduct("Роллы", (double) 560.0F);
        DiscountedProduct product3 = new DiscountedProduct("Пицца", (double) 658.0F, 20);
        DiscountedProduct product4 = new DiscountedProduct("Картофель", (double) 278.0F, 18);
        FixPriceProduct product5 = new FixPriceProduct("Кола");
        SimpleProduct product6 = new SimpleProduct("Напиток", (double) 45.0F);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        System.out.println("\n===Список товаров===\n");

        basket.printBasket();

        System.out.println("\n===Список товаров===\n");

        var removedProducts = basket.removeProduct("Картофель");
        basket.printBasket();
        System.out.println("Удаленные товары: " + removedProducts);

        System.out.println("\n===Список товаров===\n");

        var removedProductsTry = basket.removeProduct("Кола");
        if (removedProductsTry.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            basket.printBasket();
        }
        System.out.println("Удаленные товары: " + String.valueOf(removedProductsTry));
        System.out.println();
        System.out.println(basket.isHasProduct("Кола"));
        System.out.println(basket.isHasProduct("Десерт"));

        basket.deleteBasket();

        basket.printBasket();

        System.out.println(basket.isHasProduct("Картофель"));

        System.out.println("\n===Поисковая система===\n");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);

        Article article1 = new Article("1", "1");
        Article article2 = new Article("2", "2");
        Article article3 = new Article("3", "3");
        Article article4 = new Article("4", "4");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        Set<Searchable> searchResults = searchEngine.search("PRODUCT");
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }
        System.out.println();

        searchResults = searchEngine.search("ARTICLE");
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }
        System.out.println();

        searchResults = searchEngine.search("Кола");
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }

        System.out.println("\n=== Система поиска и создания исключений ===\n");

        try {
            new DiscountedProduct("Пицца", 0.3, 20);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - цена меньше одного\"");
        }
        try {
            new DiscountedProduct("", (double) 278.0F, 18);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - не введен продукт\"");
        }
        try {
            new DiscountedProduct("Пицца", (double) 658.0F, 120);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - скидка меньше ноля или больше ста процентов\"");
        }
        try {
            System.out.println(searchEngine.getSearchBestMatch("Го"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(searchEngine.getSearchBestMatch("2"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}


