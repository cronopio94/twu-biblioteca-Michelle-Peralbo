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
            if (item.isAvailable()) {
                System.out.println(item);
            }
        }
    }

    public void showMenu() {
        System.out.println("1. List of Books\n2. Checkout Book\n3. Return Book\n4. Quit");

    }

    public void selectOption(InputStream inputStream) {
        try {
            Scanner reader = new Scanner(inputStream);
            int optionSelected = reader.nextInt();

            if (optionSelected == 1) {
                printBooks();
            } else {
                if (optionSelected == 2) {
                    System.out.println("Please select the id of the book to checkout");
                    printBooks();
                    Scanner readerId = new Scanner(inputStream);
                    int idBook = readerId.nextInt();
                    checkOutBook(idBook);
                } else {
                    if (optionSelected == 3) {
                        System.out.println("Please enter the id of the book to return");
                        Scanner readerId = new Scanner(inputStream);
                        int idBook = readerId.nextInt();
                        returnBookToTheLibrary(idBook);

                    } else if (optionSelected == 4) {
                        System.exit(0);
                    } else {
                        System.out.println("Please select a valid option");
                    }
                }

            }


        } catch (InputMismatchException e) {
            System.out.println("Please select a valid option");
        }

    }


    public void checkOutBook(int idBook) {
        for (Book item : books) {
            if (item.getIdBook() == idBook) {
                item.setAvailable(false);
                System.out.println("Thank you! Enjoy the book");
                break;
            } else if (books.size() - 1 == books.indexOf(item)) {
                System.out.println("Sorry that book is not available");
            }

        }

    }


    public void returnBookToTheLibrary(int idBook) {
        for (Book item : books) {
            if (!item.isAvailable() && item.getIdBook() == idBook) {
                item.setAvailable(true);
                System.out.println("Thank you for returning the book");
                break;
            } else if (books.size() - 1 == books.indexOf(item)) {
                System.out.println("That is a not valid book to return");
            }
        }
    }
}
