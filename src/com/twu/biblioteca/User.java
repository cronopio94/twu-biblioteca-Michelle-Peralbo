package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int idUsuario;
    private String name;
    private String email;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private List<Book> borrowedBooks;

    public User(int idUsuario, String name, String email, String phoneNumber, String libraryNumber, String password) {
        this.idUsuario = idUsuario;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
        borrowedBooks = new ArrayList<Book>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + "\t" + email + "\t" + phoneNumber;
    }

}
