package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class BibliotecaTest {

    private Library library;
    private Book book1;
    private Movie movie1;
    private User user1;
    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;
    menuStrategy[] algorithms = {new ListBooks(), new CheckoutBook(), new ReturnBook(), new ListMovie(), new CheckoutMovie(), new ShowUserInformation(), new QuitApp()};


    @Before
    public void setUp() {
        //preparation
        library = new Library("test");
        book1 = new Book("Metamorphosis", "Kafka", 111, true);
        movie1 = new Movie("Avengers EndGame", 2019, "Marvel", 8);
        User user1 = new User(1, "Michelle Peralbo", "michelle123@mail.com", "0987654321", "asd-asdf", "123456");
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }

    @Test
    public void shouldShowAWelcomeMessagge() {

        library.showWelcomeMessage("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void shouldAddBookInALibrary() {
        //execution - when
        library.addBook(book1);
        int index = library.getBooks().size();

        //assertion - then
        assertEquals(1, index);
    }

    @Test
    public void shouldSeeAListofBooks() {
        library.addBook(book1);

        library.printBooks();

        assertEquals(book1.toString() + "\n", outContent.toString());
    }

    @Test
    public void shouldSeeTheMenu() {
        for (menuStrategy algorithm : algorithms) {
            executeMenu(algorithm);
        }
        assertEquals("1. List of Books\n2. Checkout book\n3. Return book\n4. List movies\n5. Checkout movie\n6. Show user information\n7. Quit\n", outContent.toString());
    }

    @Test
    public void shouldSeeABookWhenSelectedOneInMenu() {
        library.addBook(book1);
        inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
        for (menuStrategy algorithm : algorithms) {
            executeSelectOption(algorithm, 1, library);
        }

        assertEquals(book1.toString() + "\n", outContent.toString());

    }

    @Test
    public void shouldSeeInvalidOptionWhenEnterNine() {
        inContent = new ByteArrayInputStream("9".getBytes());
        System.setIn(inContent);

        //library.selectOption(inContent);

        assertEquals("Please select a valid option\n", outContent.toString());
    }


    @Test
    public void shouldCheckOutABook() {
        library.addBook(book1);

        library.checkOutBook( user1);


        assertEquals(0, library.getBooks().size());
        assertEquals(book1, library.getBooksCheckedOut().get(0));

    }

    @Test
    public void shouldSeeAMessageWhenSelectedWrongIdInCheckOut() {
        library.addBook(book1);
        int selectedId = 9;

        library.checkOutBook(user1);

        assertEquals("Sorry that book is not available\n", outContent.toString());
    }

    @Test
    public void ShouldReturnABook() {
        library.addBook(book1);
        library.checkOutBook( user1);

        library.returnBookToTheLibrary(user1);

        assertTrue(book1.isAvailable());

    }

    @Test
    public void shouldSeeAMessageWhenWrongIdEntertoReturn() {
        library.addBook(book1);
        int selectedId = 9;

        library.returnBookToTheLibrary( user1);

        assertEquals("That is a not valid book to return\n", outContent.toString());
    }

    // MOVIES
    @Test
    public void shouldAddAMovieInTheLibrary() {
        library.addMovie(movie1);
        int index = library.getMovies().size();

        assertEquals(1, index);
    }

    @Test
    public void shouldSeeAListofMovies() {
        library.addMovie(movie1);

        library.printMovies();

        assertEquals(movie1.toString() + "\n", outContent.toString());
    }

    @Test
    public void shouldCheckoutAMovie() {
        library.addMovie(movie1);

        library.checkOutMovie(movie1.getId());

        assertEquals(0, library.getMovies().size());
        assertEquals(movie1, library.getMoviesCheckedOut().get(0));

    }

    private static void executeMenu(menuStrategy strategy) {
        System.out.println(strategy.showOptionMessage());
    }

    private static void executeSelectOption(menuStrategy strategy, int optionSelected, Library library) {
        strategy.executeOption(library, optionSelected);
    }
}



