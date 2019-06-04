package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private Library library;
    private Book book1;
    private ByteArrayOutputStream outContent;

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
    public void responsiveMenuTest() throws IOException {
        //preparation
        Library library =new Library();
        //library.showMenu();


    }


}
