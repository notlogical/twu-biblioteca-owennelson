package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.core.StringEndsWith.endsWith;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

/** Test suite for outputs to console from BibliotecaApp. */

public class OutputTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final InputStream originalInput = System.in;

    @Before
    public void init() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void shutdown() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    @Test
    public void testWelcomeMessage() {
        setInput("Quit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), startsWith(Utils.WELCOME_MESSAGE + "\n"));
    }

    @Test
    public void testOptionsDisplay() {
        setInput("Quit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.OPTION_LIST + "\n"));
    }

    @Test
    public void testBookList() {
        setInput("List of books\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.BOOK_LIST));
    }

    @Test
    public void testInvalidOption() {
        setInput("Eat book\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.INVALID_OPTION_MESSAGE +
                "\n"));
    }

    @Test
    public void testCheckoutBook() {
        setInput("Checkout Clean Code\nList of books\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_CHECKOUT_MESSAGE + "\n" + Utils
                .BOOK_LIST_AFTER_CHECKOUT));
    }

    @Test
    public void testFailedCheckout() {
        setInput("Checkout The Cooking Gene\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.FAILED_CHECKOUT_MESSAGE
                + "\n"));
    }

    @Test
    public void testReturnBook() {
        setInput("Checkout Sled Driver\nReturn Sled Driver\nList of " +
                "books\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils
                .SUCCESSFUL_RETURN_MESSAGE + "\n" + Utils.BOOK_LIST));
    }

    @Test
    public void testFailedReturn() {
        setInput("Return Bosch Automotive Handbook\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.FAILED_RETURN_MESSAGE +
                "\n"));
    }

    private void setInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }
}
