package com.twu.biblioteca;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;
    private List<Book> booksCheckedOut;
    private List<Movie> movies;
    private List<Movie> moviesCheckedOut;
    private List<User> users;
    private User loggedUser;


    //constructor
    Library() {
        books = new ArrayList<Book>();
        books.add(new Book("Rayuela", "Julio Cortazar", 1963, true));
        books.add(new Book("La Tregua", "Mario Benedetti", 1959, true));
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Avenngers", 2019, "Marvel", 9));
        movies.add(new Movie("La la land", 2017, "Director", 10));
        moviesCheckedOut = new ArrayList<Movie>();
        booksCheckedOut = new ArrayList<Book>();
        users = new ArrayList<User>();
        users.add(new User(1, "Michelle Peralbo", "michelle123@mail.com", "0987654321", "asd-asdf", "123456"));
    }

    Library(String test ){
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        moviesCheckedOut = new ArrayList<Movie>();
        booksCheckedOut = new ArrayList<Book>();
        users = new ArrayList<User>();
    }

    //get
    List<Book> getBooks() {
        return books;
    }

    List<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    List<Movie> getMovies() {
        return movies;
    }

    List<Movie> getMoviesCheckedOut() {
        return moviesCheckedOut;
    }

    List<User> getUsers() {
        return users;
    }


    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public User getLoggedUser() {
        return loggedUser;
    }


    //methods
    void showWelcomeMessage(String message) {
        System.out.println(message);
    }

    void addBook(Book book) {
        books.add(book);
    }

    void printBooks() {
        for (Book item : books
        ) {
            if (item.isAvailable()) {
                System.out.println(item);
            }
        }
    }

    void selectOption(InputStream inputStream) {
        try {
            Scanner reader = new Scanner(inputStream);
            int optionSelected = reader.nextInt();

            if (optionSelected == 1) {
                printBooks();
            } else {
                if (optionSelected == 2) {
                    Scanner readerId = new Scanner(inputStream);
                    System.out.println("Please enter your library number");
                    String libraryNumber = readerId.next();
                    System.out.println("Please enter your password");
                    String password = readerId.next();
                    loggedUser = validateUser(libraryNumber, password);

                } else {
                    if (optionSelected == 3) {
                        Scanner readerId = new Scanner(inputStream);
                        System.out.println("Please enter your library number");
                        String libraryNumber = readerId.next();
                        System.out.println("Please enter your password");
                        String password = readerId.next();
                        loggedUser = validateUser(libraryNumber, password);


                    } else if (optionSelected == 4) {
                        System.exit(0);
                    } else if (optionSelected == 5) {
                        printMovies();
                    } else if (optionSelected == 6) {
                        System.out.println("Please select the id of the movie to checkout");
                        printMovies();
                        Scanner readerId = new Scanner(inputStream);
                        int idMovie = readerId.nextInt();
                        checkOutMovie(idMovie);
                    } else if (optionSelected == 7) {
                        if (loggedUser == null) {
                            System.out.println("You are not logged in");
                        } else {
                            System.out.println(loggedUser.toString());
                        }

                    } else {
                        System.out.println("Please select a valid option");
                    }
                }

            }


        } catch (InputMismatchException e) {
            System.out.println("Please select a valid option");
        }

    }


    void checkOutBook(User user) {
        System.out.println("Please select the id of the book to checkout");
        printBooks();
        Scanner readerId = new Scanner(System.in);
        int idBook1 = readerId.nextInt();
        for (Book item : books) {
            if (item.getIdBook() == idBook1) {
                booksCheckedOut.add(item);
                books.remove(item);
                user.addBorrowedBook(item);
                System.out.println("Thank you! Enjoy the book");
                break;
            } else if (books.size() - 1 == books.indexOf(item)) {
                System.out.println("Sorry that book is not available");
            }

        }

    }


    void returnBookToTheLibrary(User user) {
        System.out.println("Please select the id of the book to return");
        Scanner readerId = new Scanner(System.in);
        int idBook = readerId.nextInt();
        if (booksCheckedOut.size() == 0) {
            System.out.println("That is a not valid book to return");
        } else {
            for (Book item : booksCheckedOut) {
                if (item.getIdBook() == idBook) {
                    books.add(item);
                    booksCheckedOut.remove(item);
                    user.removeBorrowedBook(item);
                    System.out.println("Thank you for returning the book");
                    break;
                } else if (booksCheckedOut.size() - 1 == booksCheckedOut.indexOf(item)) {
                    System.out.println("That is a not valid book to return");
                }
            }
        }
    }

    void addMovie(Movie movie) {
        movies.add(movie);
    }

    void printMovies() {
        for (Movie item : movies) {
            System.out.println(item);
        }
    }

    void checkOutMovie(int idMovie) {

        for (Movie item : movies) {
            if (item.getId() == idMovie) {
                moviesCheckedOut.add(item);
                movies.remove(item);
                System.out.println("Thank you! Enjoy the movie");
                break;
            } else if (movies.size() - 1 == movies.indexOf(item)) {
                System.out.println("Sorry that movie is not available");
            }

        }


    }

    void addUser(User user) {
        users.add(user);
    }

    public User validateUser(String libraryNumber, String password) {

        for (User item : users) {
            if (item.getLibraryNumber().equals(libraryNumber) || item.getPassword().equals(password)) {
                return item;
            } else {
                System.out.println("Try again!");
            }

        }
        return null;
    }

}
