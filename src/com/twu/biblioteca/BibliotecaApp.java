package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library biblioteca=new Library();

        Book book1= new Book("Julio Cortazar",1900);
        Book book2= new Book("Eduardo Galeano",1970);
        Book book3= new Book("Lope de Vega",1700);
        biblioteca.addBook(book1);
        biblioteca.addBook(book2);
        biblioteca.addBook(book3);

        biblioteca.showMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!");
        biblioteca.printBooks();


    }
}
