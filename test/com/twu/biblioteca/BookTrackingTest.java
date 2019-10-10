package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static com.twu.biblioteca.TestingUtils.*;
import static org.junit.Assert.*;

public class BookTrackingTest {
    private Library theLibrary;
    private User user1 = new User("123-4567");
    private User user2 = new User("324-7676");

    @Before
    public void init() {
        theLibrary = new Library();
        loadBooks(theLibrary);
        loadMovies(theLibrary);
    }

    @Test
    public void testIfCheckoutLogged() {
        theLibrary.checkoutBook("Clean Code", user1);
        assertTrue(theLibrary.getHolders("Clean Code").contains(user1));
    }

    @Test
    public void testIfReturnLogged() {
        theLibrary.checkoutBook("Sled Driver", user2);
        theLibrary.returnBook("Sled Driver", user2);
        assertTrue(theLibrary.getHolders("Sled Driver").isEmpty());
    }
}
