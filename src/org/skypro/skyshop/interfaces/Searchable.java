package org.skypro.skyshop.interfaces;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getName();

    default String getStringRepresentation() {
        return " <\"Имя объекта - " + getName() + " \"> <\" Тип объекта - " + getType() + "\">";

    }
}