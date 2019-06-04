package com.twu.biblioteca;

import java.io.IOException;
import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {

        Library biblioteca=new Library();
        Book book1= new Book("Rayuela","Julio Cortazar",1900);
        Book book2= new Book("El libro","Eduardo Galeano",1970);
        biblioteca.addBook(book1);
        biblioteca.addBook(book2);

        biblioteca.showWelcomeMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!");
        biblioteca.showMenu();





    }
}
