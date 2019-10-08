package com.twu.biblioteca;

class Utils {

    static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your " +
            "one-stop-shop for great book titles in Bangalore!";

    static final String BOOK_LIST =
            "Bosch Automotive Handbook     |Robert Bosch GmbH             " +
                    "|1932\n" +
            "Clean Code                    |Robert C. Martin              " +
                    "|2008\n" +
            "Modern Global Seismology      |Thorne Lay & Terry C. Wallace " +
                    "|1995\n" +
            "One Hundred Years of Solitude |Gabriel Garcia Marquez        " +
                    "|1967\n" +
            "Sled Driver                   |Brian Shul                    " +
                    "|1991\n";

    static final String BOOK_LIST_AFTER_CHECKOUT =
            "Bosch Automotive Handbook     |Robert Bosch GmbH             " +
                    "|1932\n" +
            "Modern Global Seismology      |Thorne Lay & Terry C. Wallace " +
                    "|1995\n" +
            "One Hundred Years of Solitude |Gabriel Garcia Marquez        " +
                    "|1967\n" +
            "Sled Driver                   |Brian Shul                    " +
                    "|1991\n";

    static final String MOVIE_LIST =
            "Airplane!                     |1980|David Zucker, Jim Abrahams,." +
                    "..|8\n" +
            "The Lego Movie                |2014|Chris Miller & Phil Lord    " +
                    "  |8\n" +
            "The Pink Panther              |1963|Blake Edwards               " +
                    "  |7\n";

    static final String MOVIE_LIST_AFTER_CHECKOUT =
            "The Lego Movie                |2014|Chris Miller & Phil Lord    " +
                    "  |8\n" +
            "The Pink Panther              |1963|Blake Edwards               " +
                    "  |7\n";

    static final String OPTION_LIST =
            "Options:\n" +
            "-List of books\n" +
            "-List of movies\n" +
            "-Checkout [title]\n" +
            "-Return [title]\n" +
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

    static final String LOGIN = "Login\n123-4567\n\n";

    static final String LOGIN_SUCCESS_MESSAGE = "Thank you for logging in";

    static final String LOGIN_CHECKOUT_MESSAGE = "Please login to checkout " +
            "items";

    static final String LOGIN_RETURN_MESSAGE = "Please login to return items";
}
