package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.twu.biblioteca.Utils.LIBRARY_NUMBER_PATTERN;

public class BibliotecaApp {
    private Library _library;
    private Set<User> _users;
    private User _currentUser;
    private Scanner _consoleIn;
    private boolean _running;

    BibliotecaApp(Library library) {
        _library = library;
        _users = new HashSet<>();
        _currentUser = null;
    }

    BibliotecaApp(Library library, Set<User> users) {
        _library = library;
        _users = users;
        _currentUser = null;
    }

    public void main(String[] args) {
        _consoleIn = new Scanner(System.in);
        ConsolePrinter.printWelcome();
        ConsolePrinter.printGuestOptions();
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
                ConsolePrinter.printGuestInvalidOptionWarning();
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
                _library.returnBook(command.getItem(), _currentUser);
                break;
            case LOG_OUT:
                logOut();
                break;
            case VIEW_INFO:
                ConsolePrinter.printUserInformation(_currentUser);
                break;
            default:
                ConsolePrinter.printUserInvalidOptionWarning();
                break;
        }
    }

    private boolean isLoggedIn() {
        return _currentUser != null;
    }

    private void attemptLogin(Scanner consoleIn) {
        ConsolePrinter.printLoginPrompt();
        String libraryNumber = consoleIn.nextLine();
        if (LIBRARY_NUMBER_PATTERN.matcher(libraryNumber).matches()) {
            ConsolePrinter.printPasswordPrompt();
            String password = consoleIn.nextLine();
            checkPassword(libraryNumber, password);
        } else {
            ConsolePrinter.printInvalidLibraryNumber();
        }
    }

    private void checkPassword(String libraryNumber, String password) {
        if (true) {
            _currentUser = findUser(libraryNumber);
            ConsolePrinter.printLoginSuccess();
        }
    }

    private void logOut() {
        _currentUser = null;
        ConsolePrinter.printLogOutMessage();
    }

    private User findUser(String libraryNumber) {
        for (User user : _users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        return null;
    }
}
