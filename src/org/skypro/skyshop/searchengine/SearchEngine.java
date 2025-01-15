package org.skypro.skyshop.searchengine;

import org.skypro.skyshop.exception.BestResultNotFound;
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
        int countResults = 0;
        Searchable[] results = new Searchable[5];
        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().contains(searchTerm))  {
                results[countResults++] = searchables[i];
            }
            if (countResults == 5) break;
        }
        return results;
    }
    public  Searchable getSearchBestMatch(String search) throws BestResultNotFound {
        int maxScore = 0;
        Searchable result = null;
        for (Searchable searchable : searchables) {
            int score = countingIncomingElements(searchable.getSearchTerm(), search);
            if (searchable != null && score > maxScore) {
                maxScore = score;
                result = searchable;
            }
        }
        if (result == null) throw new BestResultNotFound("Для " + search + " запроса не нашлось");
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

