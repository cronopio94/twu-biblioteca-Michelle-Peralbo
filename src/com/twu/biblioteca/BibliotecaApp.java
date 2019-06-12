package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library biblioteca = new Library();
        Book book1 = new Book("Rayuela", "Julio Cortazar", 1963, true);
        Book book2 = new Book("La Tregua", "Mario Benedetti", 1959, true);
        Movie movie1 = new Movie("Avenngers", 2019, "Marvel", 9);
        Movie movie2 = new Movie("La la land", 2017, "Director", 10);
        User user1 = new User(1, "Michelle Peralbo", "michelle123@mail.com", "0987654321", "asd-asdf", "123456");


        biblioteca.addBook(book1);
        biblioteca.addBook(book2);
        biblioteca.addMovie(movie1);
        biblioteca.addMovie(movie2);
        biblioteca.addUser(user1);


        biblioteca.showWelcomeMessage("Welcome to Library. Your one-stop-shop for great book titles in Bangalore!");
        while (true) {
            biblioteca.showMenu();
            biblioteca.selectOption(System.in);

        }

    }
}
