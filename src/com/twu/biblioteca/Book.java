package com.twu.biblioteca;

class Book extends Media {
    private String _author;

    Book(String title, String author, int year) {
        super(title, year);
        _author = author;
        _descriptor = "book";
    }

    String getAuthor() {
        return _author;
    }

    @Override
    boolean isBook() {
        return true;
    }
}
