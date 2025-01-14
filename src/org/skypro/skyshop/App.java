package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
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
        for (Searchable result : searchResults) {
            if (result == null) continue;
            System.out.println(result.getStringRepresentation());
        }
        System.out.println();

        searchResults = searchEngine.search("ARTICLE");
        for (Searchable result : searchResults) {
            if (result == null) continue;
            System.out.println(result);
        }
        System.out.println();

        searchResults = searchEngine.search("Кола");
        for (Searchable result : searchResults) {
            if (result == null) continue;
            System.out.println(result.getSearchTerm());
        }
        System.out.println();


        System.out.println("\n=== Система поиска и создания исключений ===\n");


        DiscountedProduct[] discountedProducts = new DiscountedProduct[2];
        {
            DiscountedProduct discountedProduct1 = new DiscountedProduct("Картофель", 278.0, 18);
            DiscountedProduct discountedProduct2 = new DiscountedProduct("Пицца", 658., 20);
        }
        try {
            DiscountedProduct[] discountedProduct;
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Ошибка <IllegalArgumentException> ");
        } finally {
            System.out.println("Проверка завершена");
        }
        searchEngine.countingIncomingElements(" ", " ");
        for (Searchable count : searchResults) {
            if (count == null) continue;
            System.out.println(count);
        }
    }

}

