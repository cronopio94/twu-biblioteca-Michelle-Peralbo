package com.twu.biblioteca;


public class Book {
    private static int numberOfBooks;
    private int idBook;
    private String tittle;
    private String author;
    private int yearPublished;
    private boolean available; //true: available false: checked out


    //constructor
    public Book(String tittle,String author, int yearPublished, boolean avalaible){
        numberOfBooks++;
        this.idBook=numberOfBooks;
        this.tittle=tittle;
        this.author=author;
        this.yearPublished=yearPublished;
        this.available=avalaible;

    }

    //getters & setters

    public int getIdBook() {
        return idBook;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return idBook+"\t"+tittle+"\t"+author +"\t"+ yearPublished;
    }
}
