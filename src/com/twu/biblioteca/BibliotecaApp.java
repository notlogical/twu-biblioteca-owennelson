package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static List<Book> _books;

    public static void main(String[] args) {
        loadBooks();
        ConsolePrinter.printWelcome();
        ConsolePrinter.printBookList(_books);
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

}
