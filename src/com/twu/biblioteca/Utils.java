package com.twu.biblioteca;

import java.util.regex.Pattern;

class Utils {
    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your " +
            "one-stop-shop for great book titles in Bangalore!";

    static final String GUEST_OPTION_LIST =
            "Options:\n" +
            "-List of books\n" +
            "-List of movies\n" +
            "-Log in\n" +
            "-Quit";

    static final String USER_OPTION_LIST =
            "Options:\n" +
            "-List of books\n" +
            "-List of movies\n" +
            "-Checkout [title]\n" +
            "-Return [title]\n" +
            "-View my information\n" +
            "-Log out\n" +
            "-Quit";

    static final String INVALID_OPTION_MESSAGE = "Please select a valid " +
            "option!";

    static final String SUCCESSFUL_BOOK_CHECKOUT_MESSAGE = "Thank you! Enjoy " +
            "the book";

    static final String SUCCESSFUL_MOVIE_CHECKOUT_MESSAGE = "Thank you! Enjoy" +
            " the movie";

    static final String FAILED_CHECKOUT_MESSAGE = "Sorry, that item is not " +
            "available";

    static final String SUCCESSFUL_BOOK_RETURN_MESSAGE = "Thank you for " +
            "returning the book";

    static final String SUCCESSFUL_MOVIE_RETURN_MESSAGE = "Thank you for " +
            "returning the movie";

    static final String FAILED_RETURN_MESSAGE = "That is not a valid item to " +
            "return.";

    static final String LOGIN_SUCCESS_MESSAGE = "Thank you for logging in";

    static final String LOGIN_CHECKOUT_MESSAGE = "Please login to checkout " +
            "items";

    static final String LOGIN_RETURN_MESSAGE = "Please login to return items";

    static final String LOGIN_PROMPT = "Please enter library number in the " +
            "format 000-0000";

    static final Pattern LIBRARY_NUMBER_PATTERN = Pattern.compile("\\d{3}-\\d{4}");

    static final String INVALID_LIBRARY_NUMBER = "Please enter a valid library number";

    static final String PASSWORD_PROMPT = "Please enter password";

    static final String LOGOUT_MESSAGE = "You have logged out of Biblioteca.";
}
