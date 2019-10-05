package com.twu.biblioteca;

import org.hamcrest.core.StringEndsWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static List<Book> _books;
    private static Scanner _consoleIn;
    private static boolean _running;

    public static void main(String[] args) {
        _running = true;
        _consoleIn = new Scanner(System.in);
        loadBooks();
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        while (_running) {
            String input = _consoleIn.nextLine();
            if (input.equals("List of books")) {
                ConsolePrinter.printBookList(_books);
            } else if (input.equals("Quit")){
                _running = false;
            } else if (input.startsWith("Checkout")) {
                checkout(input.replaceFirst("Checkout ", ""));
            } else {
                ConsolePrinter.printInvalidOptionWarning();
            }
        }
    }

    private static void loadBooks() {
        _books = new ArrayList<>();
        _books.add(new Book("Bosch Automotive Handbook", "Robert Bosch GmbH",
                1932));
        _books.add(new Book("Clean Code", "Robert C. Martin", 2008));
        _books.add(new Book("Modern Global Seismology", "Thorne Lay & Terry " +
                "C. Wallace", 1995));
        _books.add(new Book("One Hundred Years of Solitude", "Gabriel Garcia " +
                "Marquez", 1967));
        _books.add(new Book("Sled Driver", "Brian Shul", 1991));
    }

    private static void checkout(String bookToCheckout) {
        Book book = findBook(bookToCheckout);
        if (book != null && book.isAvailable()){
            book.checkout();
            ConsolePrinter.printCheckoutSuccess();
        } else {
            ConsolePrinter.printCheckoutFailure();
        }
    }

    private static Book findBook(String bookToCheckout) {
        for (Book book : _books) {
            if (book.getTitle().equals(bookToCheckout)) {
                return book;
            }
        }
        return null;
    }
}
