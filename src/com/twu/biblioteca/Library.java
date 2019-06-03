package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }
//constructor
    public Library() {
        books=new ArrayList<Book>();
    }

//methods
    public void showMessage(String message) {
        System.out.println(message+"\n");
    }

    public void addBook(Book book){
        books.add(book);
    }


    public void printBooks(){
        System.out.println("Tittle"+"\t"+"Author"+"\t"+"Year\n");
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
