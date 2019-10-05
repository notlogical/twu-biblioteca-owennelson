package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static List<Book> _books;

    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        loadBooks();
        ConsolePrinter.printWelcome();
        ConsolePrinter.printOptions();
        readInput(consoleIn);
    }

    private static void readInput(Scanner consoleIn) {
        boolean running = true;
        while (running) {
            String input = consoleIn.nextLine();
            if (input.equals("List of books")) {
                ConsolePrinter.printBookList(_books);
            } else if (input.equals("Quit")) {
                running = false;
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

    private static void checkoutBook(String bookToCheckout) {
        Book book = findBook(bookToCheckout);
        if (book != null && book.isAvailable()){
            book.checkout();
            ConsolePrinter.printCheckoutSuccess();
        } else {
            ConsolePrinter.printCheckoutFailure();
        }
    }

    private static void returnBook(String bookToReturn) {
        Book book = findBook(bookToReturn);
        if (book != null && book.isCheckedOut()) {
            book.returnBook();
            ConsolePrinter.printReturnSuccess();
        } else {
            ConsolePrinter.printReturnFailure();
        }
    }

    private static Book findBook(String bookToFind) {
        for (Book book : _books) {
            if (book.getTitle().equals(bookToFind)) {
                return book;
            }
        }
        return null;
    }
}
