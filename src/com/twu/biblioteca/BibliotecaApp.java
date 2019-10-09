package com.twu.biblioteca;

import org.hamcrest.core.StringEndsWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private Library _library;
    private String _currentUser;

    BibliotecaApp(Library library) {
        _library = library;
        _currentUser = null;
    }

    public void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        readInput(consoleIn);
    }

    private void readInput(Scanner consoleIn) {
        boolean running = true;
        while (running) {
            String input = consoleIn.nextLine();
            if (input.equals("List of books")) {
                ConsolePrinter.printBookList(_library);
            } else if(input.equals("List of movies")) {
                ConsolePrinter.printMovieList(_library);
            } else if (input.equals("Quit")) {
                running = false;
            } else if (input.equals("Log in")) {
                attemptLogin(consoleIn);
            } else if (input.equals("Log out")) {
                logOut();
            } else if (input.startsWith("Checkout")) {
                if (isLoggedIn()) {
                    _library.checkoutBook(input.replaceFirst("Checkout ", ""));
                } else {
                    ConsolePrinter.printLoginToCheckout();
                }
            } else if (input.startsWith("Return")) {
                if (isLoggedIn()) {
                    _library.returnBook(input.replaceFirst("Return ", ""));
                } else {
                    ConsolePrinter.printLoginToReturn();
                }
            } else {
                ConsolePrinter.printInvalidOptionWarning();
            }
        }
    }

    private boolean isLoggedIn() {
        return _currentUser != null;
        // FIXME: 10/9/19 need to check login status before calling library.checkout/return
    }

    private void attemptLogin(Scanner consoleIn) {
        ConsolePrinter.printLoginPrompt();
        String libraryNumber = consoleIn.nextLine();
        ConsolePrinter.printPasswordPrompt();
        String password = consoleIn.nextLine();
        checkPassword(libraryNumber, password);
    }

    private void checkPassword(String libraryNumber, String password) {
        if (true) {
            _currentUser = libraryNumber;
            ConsolePrinter.printLoginSuccess();
        }
    }

    private void logOut() {
        _currentUser = null;
        ConsolePrinter.printLogOutMessage();
    }
}
