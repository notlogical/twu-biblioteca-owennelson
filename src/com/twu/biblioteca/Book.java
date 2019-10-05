package com.twu.biblioteca;

public class Book {
    private String _title;
    private String _author;
    private int _year;
    private int _quantityAvailable;
    private int _maxQuantity;

    Book(String title, String author, int year) {
        _title = title;
        _author = author;
        _year = year;
        _quantityAvailable = 1;
        _maxQuantity = 1;
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

    public boolean isAvailable() {
        return _quantityAvailable > 0;
    }

    public boolean isCheckedOut() {
        return _quantityAvailable < _maxQuantity;
    }

    void checkout() {
        _quantityAvailable--;
    }

    void returnBook() {
        _quantityAvailable++;
    }
}
