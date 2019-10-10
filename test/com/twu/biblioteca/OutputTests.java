package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

import static com.twu.biblioteca.TestingUtils.*;

/** Test suite for outputs to console from new BibliotecaApp(theLibrary). */

public class OutputTests {
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

    @Test
    public void testWelcomeMessage() {
        setInputAfterLogin("Quit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), startsWith(Utils.WELCOME_MESSAGE + "\n"));
    }

    @Test
    public void testOptionsDisplay() {
        setInputAfterLogin("Quit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils.GUEST_OPTION_LIST + "\n" +
                LOGIN_SEQUENCE));
    }

    @Test
    public void testBookList() {
        setInputAfterLogin("List of books\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(BOOK_LIST));
    }

    @Test
    public void testMovieList() {
        setInputAfterLogin("List of movies\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(MOVIE_LIST));
    }

    @Test
    public void testInvalidOption() {
        setInputAfterLogin("Eat book\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), containsString(Utils.INVALID_OPTION_MESSAGE +
                "\n"));
    }

    @Test
    public void testCheckoutBook() {
        setInputAfterLogin("Checkout Clean Code\nList of books\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_BOOK_CHECKOUT_MESSAGE + "\n" + BOOK_LIST_AFTER_CHECKOUT));
    }

    @Test
    public void testCheckoutMovie() {
        setInputAfterLogin("Checkout Airplane!\nList of movies\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE + "\n" + MOVIE_LIST_AFTER_CHECKOUT));
    }

    @Test
    public void testFailedCheckout() {
        setInputAfterLogin("Checkout The Cooking Gene\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils.FAILED_CHECKOUT_MESSAGE
                + "\n"));
    }

    @Test
    public void testReturnBook() {
        setInputAfterLogin("Checkout Sled Driver\nReturn Sled Driver\nList of " +
                "books\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_BOOK_RETURN_MESSAGE + "\n" + BOOK_LIST));
    }

    @Test
    public void testReturnMovie() {
        setInputAfterLogin("Checkout The Pink Panther\nReturn The Pink Panther\nList of" +
                " movies\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_MOVIE_RETURN_MESSAGE + "\n" + MOVIE_LIST));
    }

    @Test
    public void testFailedReturn() {
        setInputAfterLogin("Return Bosch Automotive Handbook\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils.FAILED_RETURN_MESSAGE +
                "\n"));
    }
}
