package com.twu.biblioteca;


public class Book {

    private String tittle;
    private String author;
    private int yearPublished;
    private boolean checkedOut;

    //constructor
    public Book(String tittle,String author, int yearPublished){
        this.tittle=tittle;
        this.author=author;
        this.yearPublished=yearPublished;
    }

    //getters & setters


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


    @Override
    public String toString() {
        return tittle+"\t"+author +"\t"+ yearPublished;
    }
}
