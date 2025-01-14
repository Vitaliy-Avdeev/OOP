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

    public Searchable[] search(String search) {
        int countResult = 0;
        Searchable[] result = null;
        for (Searchable searchable : searchables) {
            int score = countingIncomingElements(searchable.getSearchTerm(), search);
            if (searchable != null && score > countResult) {
                countResult = score;
                result = new Searchable[]{searchable};
            }
            if (countResult == 5) break;
        }
        return result;
    }

    public int countingIncomingElements(String str, String substr) {
        int count = 0;
        for (int index = 0; (index = str.indexOf(substr, index)) != -1; index += substr.length()) {
            count++;
        }
        return count;
    }

}

