package com.twu.biblioteca;

import java.io.IOException;


public class BibliotecaApp {

    public static void main(String[] args) throws IOException {

        Library biblioteca=new Library();
        Book book1= new Book("Rayuela","Julio Cortazar",1900, true);
        Book book2= new Book("El libro","Eduardo Galeano",1970, true);
        biblioteca.addBook(book1);
        biblioteca.addBook(book2);
        biblioteca.showWelcomeMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!");
        while (true) {
            biblioteca.showMenu();
            biblioteca.selectOption(System.in);

        }

    }
}
