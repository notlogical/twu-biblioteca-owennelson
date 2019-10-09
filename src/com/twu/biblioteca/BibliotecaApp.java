package com.twu.biblioteca;

import org.hamcrest.core.StringEndsWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    private Library _library;
    private String _currentUser;
    private Scanner _consoleIn;

    BibliotecaApp(Library library) {
        _library = library;
        _currentUser = null;
    }

    public void main(String[] args) {
        _consoleIn = new Scanner(System.in);
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        readInput()
    }

    private void readInput() {
        boolean running = true;
        while (running) {
            String input = _consoleIn.nextLine();
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
                    _library.checkoutBook(input.replaceFirst("Checkout ", ""), _currentUser);
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

    private void readGuestInput(String input, Boolean running) {
        switch (input) {
            case "List of books":
                ConsolePrinter.printBookList(_library);
                break;
            case "List of movies":
                ConsolePrinter.printMovieList(_library);
                break;
            case "Quit":
                running = false;
                break;
            case "Log in":
                attemptLogin(_consoleIn);
                break;
            case "Checkout":
                // Need to figure out how to deal with starts with in switch.
                // maybe first parse the input into a command object/interface, then use that as the input
        }
    }

    private void readUserInput(Scanner input) {

    }

    private boolean isLoggedIn() {
        return _currentUser != null;
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
