package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private Library library;
    private Book book1;
    private ByteArrayOutputStream outContent;
    private ByteArrayInputStream inContent;

    @Before
    public void setUp() {
        //preparation
        library= new Library();
        book1=new Book("Metamorphosis","Kafka", 111);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


    }

    @Test
    public void shouldShowAWelcomeMessagge(){

        library.showWelcomeMessage("Welcome");

        assertEquals("Welcome\n", outContent.toString());
    }

    @Test
    public void shouldAddBookInALibrary() {
        //execution - when
        library.addBook(book1);
        int index=library.getBooks().size();

        //assertion - then
        assertEquals(1,index);
    }
    @Test
    public void shouldSeeAListofBooks(){
        library.addBook(book1);
        library.printBooks();

        assertEquals(book1.toString()+"\n",outContent.toString());
    }

    @Test
    public void shouldSeeTheMenu(){
        library.showMenu();
        assertEquals("1. List of Books\n2. Quit\n",outContent.toString());
    }

    @Test
    public void shouldSeeABookWhenSelectedOneInMenu(){
        library.addBook(book1);
        inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);

        library.selectOption(inContent);
        assertEquals(book1.toString()+"\n",outContent.toString());

    }

    @Test
    public void shouldSeeInvalidOptionWhenEnterFive(){
        inContent= new ByteArrayInputStream("5".getBytes());
        System.setIn(inContent);
        library.selectOption(inContent);

        assertEquals("Please select a valid option\n",outContent.toString());
    }
@Test
    public void shouldSeeInvalidOptionWhenEnterLetter(){
        inContent=new ByteArrayInputStream("d".getBytes());
        System.setIn(inContent);
        library.selectOption(inContent);
        assertEquals("Please select a valid option\n",outContent.toString());
}

@Test
    public void shouldQuitBibliotecaWhenSelectedThree(){
        inContent= new ByteArrayInputStream("2".getBytes());
        System.setIn(inContent);
        library.selectOption(inContent);
}

}
