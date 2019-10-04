package com.twu.biblioteca;

public class Book {
    private String _title;
    private String _author;
    private int _year;

    Book(String title, String author, int year) {
        _title = title;
        _author = author;
        _year = year;
    }

    public String getTitle() {
        return _title;
    }

    public String getAuthor() {
        return _author;
    }

    public int getYear() {
        return _year;
    }
}
