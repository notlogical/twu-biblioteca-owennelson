package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {

    private static List<Book> _books;

    public static void main(String[] args) {
        loadBooks();
        System.out.println(Utils.WELCOME_TEXT);
        printBookList(_books);
    }

    private static void loadBooks() {

    }

    private static void printBookList(List<Book> books) {
        for (Book book : books) {
            printBook(book);
        }
    }

    private static void printBook(Book book) {
        System.out.println(book.title);
    }
}
