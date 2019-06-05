package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;

    //constructor
    public Library() {
        books = new ArrayList<Book>();
    }

    //get
    public List<Book> getBooks() {
        return books;
    }

    //methods
    public void showWelcomeMessage(String message) {
        System.out.println(message);
    }

    public void addBook(Book book) {
        books.add(book);
    }


    public void printBooks() {
        for (Book item : books
        ) {
            System.out.println(item);
        }
    }

    public void showMenu() {
        System.out.println("1. List of Books\n2. Quit");

    }

    public void selectOption(InputStream inputStream) {
        try {
            Scanner reader = new Scanner(inputStream);
            int optionSelected = reader.nextInt();

            if (optionSelected == 1) {
                printBooks();
            }

            if(optionSelected == 2){
                System.exit(0);
            }

            if(optionSelected!=1){
                System.out.println("Please select a valid option");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please select a valid option");
        }

    }


}
