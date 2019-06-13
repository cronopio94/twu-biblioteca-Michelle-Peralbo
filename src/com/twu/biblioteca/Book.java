package com.twu.biblioteca;


public class Book {
    private static int numberOfBooks;
    private int idBook;
    private String tittle;
    private String author;
    private int yearPublished;
    private boolean available;


    //constructor
    Book(String tittle, String author, int yearPublished, boolean available) {
        numberOfBooks++;
        this.idBook = numberOfBooks;
        this.tittle = tittle;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = available;

    }

    //getters & setters

    int getIdBook() {
        return idBook;
    }

    boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return idBook + "\t" + tittle + "\t" + author + "\t" + yearPublished;
    }
}
