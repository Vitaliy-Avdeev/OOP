package org.skypro.skyshop.article;

import org.skypro.skyshop.interfaces.Searchable;

public class Article implements Searchable {
    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleText() {
        return articleText;
    }

    @Override
    public String toString() {
        return "Название статьи: " + getArticleTitle() + '\n' + "Текст статьи: " + getArticleText();
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
}
