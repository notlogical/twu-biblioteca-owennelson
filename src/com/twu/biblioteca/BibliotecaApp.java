package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static List<Book> _books;

    public static void main(String[] args) {
        loadBooks();
        System.out.println(Utils.WELCOME_TEXT);
        printBookList(_books);
    }

    private static void loadBooks() {
        _books = new ArrayList<>();
        _books.add(new Book("Bosch Automotive Handbook"));
        _books.add(new Book("Clean Code"));
        _books.add(new Book("Modern Global Seismology"));
        _books.add(new Book("One Hundred Years of Solitude"));
        _books.add(new Book("Sled Driver"));
    }

    private static void printBookList(List<Book> books) {
        for (Book book : books) {
            printBook(book);
        }
    }

    private static void printBook(Book book) {
        System.out.println(book.getTitle());
    }
}
