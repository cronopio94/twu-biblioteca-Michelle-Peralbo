package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

//constructor
    public Library() {
        books=new ArrayList<Book>();
    }

//get
    public List<Book> getBooks() {
        return books;
    }

//methods
    public void showWelcomeMessage(String message) {
        System.out.println(message);
    }

    public void addBook(Book book){
        books.add(book);
    }


    public void printBooks(){
        for (Book item: books
             ) {
            System.out.println(item);
        }
    }

    public void showMenu() throws IOException {
        while(true){

            System.out.println("1. List of Books");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            int inputOption= Integer.parseInt(buffer.readLine());

            if(inputOption==1){
                printBooks();
            }else{
                System.out.println("Please select a valid option!");
            }

        }
    }
}
