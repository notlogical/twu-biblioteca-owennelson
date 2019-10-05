package com.twu.biblioteca;

abstract class Media {
    private String _title;
    private int _year;
    private int _quantityAvailable;
    private int _maxQuantity;

    Media(String title, int year) {
        _title = title;
        _year = year;
        _quantityAvailable = 1;
        _maxQuantity = 1;
    }

    String getTitle() {
        return _title;
    }

    int getYear() {
        return _year;
    }

    boolean isAvailable() {
        return _quantityAvailable > 0;
    }

    boolean isCheckedOut() {
        return _quantityAvailable < _maxQuantity;
    }

    void checkout() {
        _quantityAvailable--;
    }

    void returnBook() {
        _quantityAvailable++;
    }

    boolean isBook() {
        return false;
    }

    boolean isMovie() {
        return false;
    }
}
