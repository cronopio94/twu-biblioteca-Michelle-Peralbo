package com.twu.biblioteca;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void addBookTest() {
        //preparation -given
        Library library = new Library();
        Book book1 = new Book("Metamorphosis","Kafka", 111);

        //execution - when
        library.addBook(book1);

        //assertion - then
        assertEquals(1,library.getBooks().size());
    }
    @Test
    public void responsiveMenuTest() throws IOException {
        //preparation
        Library library =new Library();
        library.showMenu();


    }


}
