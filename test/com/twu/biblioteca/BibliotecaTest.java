package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void addBook() {
        //preparation -given
        Library library = new Library();
        Book book1 = new Book("Kafka", 111);

        //execution - when
        library.addBook(book1);

        //assertion - then
        assertEquals(1,library.getBooks().size());
    }


}
