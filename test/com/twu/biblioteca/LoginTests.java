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

public class LoginTests {
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
    public void testCheckoutWithoutLogin() {
        setInput("Checkout Clean Code\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_CHECKOUT_MESSAGE +
                "\n"));
    }

    @Test
    public void testLoggingIn() {
        setInput(Utils.LOGIN + "Checkout Clean Code\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_SUCCESS_MESSAGE +
                        "\n" + Utils.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE + "\n"));
    }

    @Test
    public void testLoginLogout() {
        setInput(Utils.LOGIN + "Log out\nCheckout Clean Code\nQuit");
        BibliotecaApp.main(null);
        assertThat(output.toString(), endsWith(Utils.LOGIN_CHECKOUT_MESSAGE));
    }

    private void setInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }
}
