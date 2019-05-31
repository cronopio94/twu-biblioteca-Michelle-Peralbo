package com.twu.biblioteca;

import java.util.Date;

public class Book {
    private String author;
    private int yearPublished;

    public Book(String author, int yearPublished){
        this.author=author;
        this.yearPublished=yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return author +" "+ yearPublished;
    }
}
