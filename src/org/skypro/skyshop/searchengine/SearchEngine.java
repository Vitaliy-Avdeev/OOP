package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.interfaces.Searchable;

public class SearchEngine {
    private int count = 0;
    private Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public void add(Searchable searchable) {
        if (count >= searchables.length) {
            System.out.println(" Добавить объект невозможно! ");
        } else {
            searchables[count++] = searchable;
        }
    }

    public Searchable[] search(String searchTerm) {
        int countResult = 0;
        Searchable[] result = new Searchable[5];
        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(searchTerm)) {
                result[countResult++] = searchables[i];
            }
            if (countResult == 5) break;
        }
        return result;
    }
}



