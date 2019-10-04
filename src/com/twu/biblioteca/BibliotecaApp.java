package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static List<Book> _books;
    private static int fieldWidth = 30;

    public static void main(String[] args) {
        loadBooks();
        ConsolePrinter.printWelcome();
        printBookList(_books);
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

    private static void printBookList(List<Book> books) {
        for (Book book : books) {
            printBook(book);
        }
    }

    private static void printBook(Book book) {
        System.out.println(fitText(book.getTitle()) + "|" + fitText(book
                .getAuthor()) + "|" + book.getYear());
    }

    private static String fitText(String text) {
        if (text.length() > fieldWidth) {
            return trimText(text);
        } else {
            return padText(text);
        }
    }

    private static String trimText(String text) {
        return text.substring(0, 27) + "...";
    }

    private static String padText(String text) {
        return text.format("%-" + fieldWidth + "s", text);
    }
}
