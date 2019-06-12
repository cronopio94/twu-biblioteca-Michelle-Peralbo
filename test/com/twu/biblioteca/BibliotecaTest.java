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

    @Before
    public void setUp() {
        //preparation
        library = new Library();
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
        library.showMenu();

        assertEquals("1. List of Books\n2. Checkout Book\n3. Return Book\n4. Quit\n", outContent.toString());
    }

    @Test
    public void shouldSeeABookWhenSelectedOneInMenu() {
        library.addBook(book1);
        inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);

        library.selectOption(inContent);

        assertEquals(book1.toString() + "\n", outContent.toString());

    }

    @Test
    public void shouldSeeInvalidOptionWhenEnterNine() {
        inContent = new ByteArrayInputStream("9".getBytes());
        System.setIn(inContent);

        library.selectOption(inContent);

        assertEquals("Please select a valid option\n", outContent.toString());
    }

    @Test
    public void shouldSeeInvalidOptionWhenEnterLetter() {
        inContent = new ByteArrayInputStream("d".getBytes());
        System.setIn(inContent);

        library.selectOption(inContent);

        assertEquals("Please select a valid option\n", outContent.toString());
    }

    @Test
    public void shouldCheckOutABook() {
        library.addBook(book1);

        library.checkOutBook(book1.getIdBook(), user1);


        assertEquals(0, library.getBooks().size());
        assertEquals(book1, library.getBooksCheckedOut().get(0));

    }

    @Test
    public void shouldSeeAMessageWhenSelectedWrongIdInCheckOut() {
        library.addBook(book1);
        int selectedId = 9;

        library.checkOutBook(selectedId, user1);

        assertEquals("Sorry that book is not available\n", outContent.toString());
    }

    @Test
    public void ShouldReturnABook() {
        library.addBook(book1);
        library.checkOutBook(book1.getIdBook(), user1);

        library.returnBookToTheLibrary(book1.getIdBook(), user1);

        assertTrue(book1.isAvailable());

    }

    @Test
    public void shouldSeeAMessageWhenWrongIdEntertoReturn() {
        library.addBook(book1);
        int selectedId = 9;

        library.returnBookToTheLibrary(selectedId, user1);

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

}



