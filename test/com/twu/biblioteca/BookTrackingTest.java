package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static com.twu.biblioteca.TestingUtils.*;
import static org.junit.Assert.*;

public class BookTrackingTest {
    private Library theLibrary;

    @Before
    public void init() {
        theLibrary = new Library();
        loadBooks(theLibrary);
        loadMovies(theLibrary);
    }

    @Test
    public void testIfCheckoutLogged() {
        theLibrary.checkoutBook("Clean Code", USER1);
        assertTrue(theLibrary.getHolders("Clean Code").contains(USER1));
    }

    @Test
    public void testIfReturnLogged() {
        theLibrary.checkoutBook("Sled Driver", USER2);
        theLibrary.returnBook("Sled Driver", USER2);
        assertTrue(theLibrary.getHolders("Sled Driver").isEmpty());
    }
}
