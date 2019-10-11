package com.twu.biblioteca;

public class User {
    private String _libraryNumber;
    private String _name;
    private String _email;
    private String _phoneNumber;

    User(String libraryNumber) {
        _libraryNumber = libraryNumber;
        _name = "No name on file";
        _email = "No email on file";
        _phoneNumber = "No phone number on file";
    }

    User(String libraryNumber, String name, String email, String phoneNumber) {
        _libraryNumber = libraryNumber;
        _name = name;
        _email = email;
        _phoneNumber = phoneNumber;
    }

    String getLibraryNumber() {
        return _libraryNumber;
    }

    String getInformation() {
        return _name + "\n" + _email + "\n" + _phoneNumber;
    }
}
