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

    static final String OPTION_LIST =
            "Options:\n" +
            "-List of books\n" +
            "-Checkout [book title]\n" +
            "-Quit";

    static final String INVALID_OPTION_MESSAGE = "Please select a valid " +
            "option!";

    static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the " +
            "book";

    static final String FAILED_CHECKOUT_MESSAGE = "Sorry, that book is not " +
            "available";
}
