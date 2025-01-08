package org.skypro.skyshop.interfaces;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getName();

    default String getStringRepresentation() {
        return "имя" + getName() + "-объекта — тип" + getType() + "-объекта";
    }
}