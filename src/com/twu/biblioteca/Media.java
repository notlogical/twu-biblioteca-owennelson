package com.twu.biblioteca;

abstract class Media {
    private String _title;
    private int _year;
    private int _quantityAvailable;
    private int _maxQuantity;
    String _descriptor;
    String _holder;

    Media(String title, int year) {
        _title = title;
        _year = year;
        _quantityAvailable = 1;
        _maxQuantity = 1;
        _holder = null;
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

    void checkout(String user) {
        _quantityAvailable--;
        _holder = user;
    }

    void returnItem() {
        _quantityAvailable++;
        _holder = null;
    }

    String getHolder() {
        return _holder;
    }

    String getDescriptor() {
        return _descriptor;
    }

    boolean isBook() {
        return false;
    }

    boolean isMovie() {
        return false;
    }
}
