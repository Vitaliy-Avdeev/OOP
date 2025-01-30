package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

import java.util.Objects;

public record Article(String articleTitle, String articleText) implements Searchable {

    @Override
    public String toString() {
        return "Название статьи: " + articleTitle() + '\n' + "Текст статьи: " + articleText();
    }

    @Override
    public String getSearchTerm() {
        return this + " " + getType();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return articleTitle + " \nТип - ARTICLE";
    }


    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleText, article.articleText) && Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleText);
    }
}
