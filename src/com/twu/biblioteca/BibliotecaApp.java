package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private Library _library;
    private String _currentUser;
    private Scanner _consoleIn;
    private boolean _running;

    BibliotecaApp(Library library) {
        _library = library;
        _currentUser = null;
    }

    public void main(String[] args) {
        _consoleIn = new Scanner(System.in);
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        _running = true;
        readInput();
    }

    private void readInput() {
        while (_running) {
            String input = _consoleIn.nextLine();
            if (isLoggedIn()) {
                processUserInput(new Command(input));
            } else {
                processGuestInput(new Command(input));
            }
        }
    }

    private void processGuestInput(Command command) {
        switch (command.getType()) {
            case LIST_BOOKS:
                ConsolePrinter.printBookList(_library);
                break;
            case LIST_MOVIES:
                ConsolePrinter.printMovieList(_library);
                break;
            case QUIT:
                _running = false;
                break;
            case LOG_IN:
                attemptLogin(_consoleIn);
                break;
            case CHECKOUT:
                ConsolePrinter.printLoginToCheckout();
                break;
            case RETURN:
                ConsolePrinter.printLoginToReturn();
                break;
            default:
                ConsolePrinter.printInvalidOptionWarning();
                break;
        }
    }

    private void processUserInput(Command command) {
        switch (command.getType()) {
            case LIST_BOOKS:
                ConsolePrinter.printBookList(_library);
                break;
            case LIST_MOVIES:
                ConsolePrinter.printMovieList(_library);
                break;
            case QUIT:
                _running = false;
                break;
            case CHECKOUT:
                _library.checkoutBook(command.getItem(), _currentUser);
                break;
            case RETURN:
                _library.returnBook(command.getItem());
                break;
            case LOG_OUT:
                logOut();
                break;
            default:
                ConsolePrinter.printInvalidOptionWarning();
                break;
        }
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
        // need to ensure valid library ID
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
