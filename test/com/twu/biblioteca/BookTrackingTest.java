package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.TestingUtils.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class BookTrackingTest {
    private Library theLibrary;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @Before
    public void init() {
        System.setOut(new PrintStream(output));
        theLibrary = new Library();
        loadBooks(theLibrary);
        loadMovies(theLibrary);
    }

    @After
    public void shutdown() {
        System.setOut(originalOutput);
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

    @Test
    public void testReturnBookNotCheckedOut() {
        theLibrary.returnBook("Sled Driver", USER1);
        assertThat(output.toString(), containsString(Utils.FAILED_RETURN_MESSAGE));
    }

    @Test
    public void testReturnBookCheckedOutByOtherUser() {
        theLibrary.checkoutBook("Sled Driver", USER1);
        theLibrary.returnBook("Sled Driver", USER2);
        assertThat(output.toString(), containsString(Utils.FAILED_RETURN_MESSAGE));
    }
}
