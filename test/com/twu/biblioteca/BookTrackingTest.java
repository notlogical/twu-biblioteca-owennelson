package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.TestingUtils.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.hamcrest.core.Is.is;

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
        theLibrary.checkoutBook("Clean Code", "123-4567");
        assertThat(theLibrary.getHolder("Clean Code"), is("123-4567"));
    }

    @Test
    public void testIfReturnLogged() {
        theLibrary.checkoutBook("Sled Driver", "324-7676");
        theLibrary.returnBook("Sled Driver");
        assertNull(theLibrary.getHolder("Sled Driver"));
    }
}
