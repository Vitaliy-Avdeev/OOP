package org.skypro.skyshop.comparator;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Comparator;

public class ComparatorOfOrder implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (o1.getStringRepresentation().length() != o2.getStringRepresentation().length()) {
            return Integer.compare(o2.getStringRepresentation().length(), o1.getStringRepresentation().length());
        }
        return o1.getStringRepresentation().compareTo(o2.getStringRepresentation());
    }
}
