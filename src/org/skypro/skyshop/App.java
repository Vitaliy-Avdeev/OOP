package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.interfaces.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchengine.SearchEngine;

public class App {
    public static void main(String[] args) {
        SimpleProduct product1 = new SimpleProduct("Коктель", 89.0);
        SimpleProduct product2 = new SimpleProduct("Роллы", 560.);
        DiscountedProduct product3 = new DiscountedProduct("Пицца", 658., 20);
        DiscountedProduct product4 = new DiscountedProduct("Картофель", 278.0, 18);
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

        System.out.println("\n===Поисковая система===\n");

        SearchEngine searchEngine = new SearchEngine(9);
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

        Searchable[] searchResults = searchEngine.search("PRODUCT");
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

        searchResults = searchEngine.search("Картофель");
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }
        System.out.println();

        System.out.println("\n=== Система поиска и создания исключений ===\n");
        try {
            new DiscountedProduct("Пицца", 0.3, 20);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException var22) {
            System.out.println("\"Ошибка - цена меньше одного\"");
        }

        try {
            new DiscountedProduct("", (double)278.0F, 18);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException var21) {
            System.out.println("\"Ошибка - не введен продукт\"");
        }
        try {
            new DiscountedProduct("Пицца", (double)658.0F, 120);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException var20) {
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



