package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.TestingUtils.*;

public class BookTrackingTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final InputStream originalInput = System.in;
    private Library theLibrary;

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
        System.setIn(originalInput);
    }

    /*@Test
    public void testIfCheckoutLogged() {
        //Log in, check out book. Check if book is logged out and if user matches
        // Will need to set biblioteca up to be instantiated so that it persists after input
        setInput(Utils.LOGIN);
    }*/
}
