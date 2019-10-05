package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
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

    private BibliotecaApp biblioteca;


    @Before
    public void init() {
        System.setOut(new PrintStream(output));
        biblioteca = new BibliotecaApp();
        biblioteca.main(null);
    }

    @After
    public void shutdown() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    @Test
    public void testWelcomeMessage() {
        assertThat(output.toString(), startsWith(Utils.WELCOME_TEXT + "\n"));
    }

    @Test
    public void testOptionsDisplay() {
        assertThat(output.toString(), endsWith(Utils.OPTION_LIST));
    }

    @Test
    public void testBookList() {
        System.setIn(new ByteArrayInputStream("List of books".getBytes()));
        assertThat(output.toString(), endsWith(Utils.BOOK_LIST));
    }
}
