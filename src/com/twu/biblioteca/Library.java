package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;


    public Library() {
        books=new ArrayList<Book>();
    }


    public void showMessage(String message) {
        System.out.println(message);
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void printBooks(){
        System.out.println("Author");
        for (Book item: books
             ) {
            System.out.println(item);
        }
    }


    public List<Book> getBooks() {
        return books;
    }
}
