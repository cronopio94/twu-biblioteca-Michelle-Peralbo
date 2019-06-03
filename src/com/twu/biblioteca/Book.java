package com.twu.biblioteca;


public class Book {

    private String name;
    private String author;
    private int yearPublished;

    //constructor
    public Book(String name,String author, int yearPublished){
        this.name=name;
        this.author=author;
        this.yearPublished=yearPublished;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name+"\t"+author +"\t"+ yearPublished;
    }
}
