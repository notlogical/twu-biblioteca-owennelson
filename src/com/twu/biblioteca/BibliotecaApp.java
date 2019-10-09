package com.twu.biblioteca;

import org.hamcrest.core.StringEndsWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static List<Media> _allMedia;
    private static String _currentUser;

    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        _allMedia = new ArrayList<>();
        _currentUser = null;
        loadBooks();
        loadMovies();
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        readInput(consoleIn);
    }

    private static void readInput(Scanner consoleIn) {
        boolean running = true;
        while (running) {
            String input = consoleIn.nextLine();
            if (input.equals("List of books")) {
                ConsolePrinter.printBookList(_allMedia);
            } else if(input.equals("List of movies")) {
                ConsolePrinter.printMovieList(_allMedia);
            } else if (input.equals("Quit")) {
                running = false;
            } else if (input.equals("Log in")) {
                attemptLogin(consoleIn);
            } else if (input.equals("Log out")) {
                logOut();
            } else if (input.startsWith("Checkout")) {
                checkoutBook(input.replaceFirst("Checkout ", ""));
            } else if (input.startsWith("Return")) {
                returnBook(input.replaceFirst("Return ", ""));
            } else {
                ConsolePrinter.printInvalidOptionWarning();
            }
        }
    }

    private static void loadBooks() {
        _allMedia.add(new Book("Bosch Automotive Handbook", "Robert Bosch GmbH",
                1932));
        _allMedia.add(new Book("Clean Code", "Robert C. Martin", 2008));
        _allMedia.add(new Book("Modern Global Seismology", "Thorne Lay & Terry " +
                "C. Wallace", 1995));
        _allMedia.add(new Book("One Hundred Years of Solitude", "Gabriel Garcia " +
                "Marquez", 1967));
        _allMedia.add(new Book("Sled Driver", "Brian Shul", 1991));
    }

    private static void loadMovies() {
        _allMedia.add(new Movie("Airplane!", 1980, "David Zucker, Jim Abrahams," +
                " & Jerry Zucker", "8"));
        _allMedia.add(new Movie("The Lego Movie", 2014, "Chris Miller & Phil " +
                "Lord", "8"));
        _allMedia.add(new Movie("The Pink Panther", 1963, "Blake Edwards", "7"));
    }

    private static void checkoutBook(String bookToCheckout) {
        if (isLoggedIn()) {
            Media media = findMedia(bookToCheckout);
            if (media != null && media.isAvailable()) {
                media.checkout();
                ConsolePrinter.printCheckoutSuccess(media.getDescriptor());
            } else {
                ConsolePrinter.printCheckoutFailure();
            }
        } else {
            ConsolePrinter.printLoginToCheckout();
        }
    }

    private static void returnBook(String bookToReturn) {
        if (isLoggedIn()) {
            Media media = findMedia(bookToReturn);
            if (media != null && media.isCheckedOut()) {
                media.returnBook();
                ConsolePrinter.printReturnSuccess(media.getDescriptor());
            } else {
                ConsolePrinter.printReturnFailure();
            }
        } else {
            ConsolePrinter.printLoginToReturn();
        }
    }

    private static Media findMedia(String mediaToFind) {
        for (Media media : _allMedia) {
            if (media.getTitle().equals(mediaToFind)) {
                return media;
            }
        }
        return null;
    }

    private static boolean isLoggedIn() {
        return _currentUser != null;
    }

    private static void attemptLogin(Scanner consoleIn) {
        ConsolePrinter.printLoginPrompt();
        String libraryNumber = consoleIn.nextLine();
        ConsolePrinter.printPasswordPrompt();
        String password = consoleIn.nextLine();
        checkPassword(libraryNumber, password);
    }

    private static void checkPassword(String libraryNumber, String password) {
        if (true) {
            _currentUser = libraryNumber;
            ConsolePrinter.printLoginSuccess();
        }
    }

    private static void logOut() {
        _currentUser = null;
        ConsolePrinter.printLogOutMessage();
    }
}
