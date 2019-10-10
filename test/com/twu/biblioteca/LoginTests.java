package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.TestingUtils.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.StringEndsWith.endsWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class LoginTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final InputStream originalInput = System.in;
    private Library theLibrary;
    private Set<User> users = new HashSet<>();

    @Before
    public void init() {
        System.setOut(new PrintStream(output));
        theLibrary = new Library();
        loadBooks(theLibrary);
        loadMovies(theLibrary);
        users.add(USER1);
    }

    @After
    public void shutdown() {
        System.setOut(originalOutput);
        System.setIn(originalInput);
    }

    @Test
    public void testCheckoutWithoutLogin() {
        setInput("Checkout Clean Code\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_CHECKOUT_MESSAGE +
                "\n"));
    }

    @Test
    public void testLoggingIn() {
        setInput(LOGIN + "Checkout Clean Code\nQuit");
        new BibliotecaApp(theLibrary, users).main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_SUCCESS_MESSAGE +
                        "\n" + Utils.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE + "\n"));
    }

    @Test
    public void testLoginLogout() {
        setInput(LOGIN + "Log out\nCheckout Clean Code\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_CHECKOUT_MESSAGE +
        "\n"));
    }

    @Test
    public void testInvalidLogin() {
        setInput("Log in\nnot a library number\n\nCheckout Sled Driver\nQuit");
        new BibliotecaApp(theLibrary).main(null);
        assertThat(output.toString(), containsString(Utils.INVALID_LIBRARY_NUMBER));
        assertThat(output.toString(), endsWith(Utils.LOGIN_CHECKOUT_MESSAGE + "\n"));
    }
}
