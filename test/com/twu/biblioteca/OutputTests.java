package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.rmi.CORBA.Util;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Test suite for outputs to console from BibliotecaApp. */

public class OutputTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    BibliotecaApp biblioteca;


    @Before
    public void init() {
        System.setOut(new PrintStream(output));
        biblioteca = new BibliotecaApp();
        biblioteca.main(null);
    }

    @After
    public void shutdown() {
        System.setOut(originalOutput);
    }

    @Test
    public void testWelcomeMessage() {
        assertThat(output.toString(),is(Utils.WELCOME_TEXT));
    }
}
