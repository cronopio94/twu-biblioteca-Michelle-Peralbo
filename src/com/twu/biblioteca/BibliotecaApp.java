package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library biblioteca = new Library();
        Book book1 = new Book("Rayuela", "Julio Cortazar", 1963, true);
        Book book2 = new Book("La Tregua", "Mario Benedetti", 1959, true);
        biblioteca.addBook(book1);
        biblioteca.addBook(book2);
        biblioteca.showWelcomeMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!");
        while (true) {
            biblioteca.showMenu();
            biblioteca.selectOption(System.in);

        }

    }
}
