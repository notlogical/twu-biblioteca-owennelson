package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Set;

abstract class Media {
    private String _title;
    private int _year;
    private int _quantityAvailable;
    private int _maxQuantity;
    String _descriptor;
    Set<User> _holders;

    Media(String title, int year) {
        _title = title;
        _year = year;
        _quantityAvailable = 1;
        _maxQuantity = 1;
        _holders = new HashSet<>();
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

    boolean isCheckedOut(User user) {
        return _holders.contains(user);
    }

    void checkout(User user) {
        _quantityAvailable--;
        _holders.add(user);
    }

    void returnItem(User user) {
        _quantityAvailable++;
        _holders.remove(user);
    }

    Set<User> getHolders() {
        return _holders;
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
