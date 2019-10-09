package com.twu.biblioteca;

import java.io.ByteArrayInputStream;

public class TestingUtils {
    static void setInput(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    static void setInputAfterLogin(String string) {
        System.setIn(new ByteArrayInputStream(prependTextWithLogin(string)
                .getBytes()));
    }

    private static String prependTextWithLogin(String string) {
        return LOGIN + string;
    }

    static final String LOGIN = "Log in\n123-4567\n\n";

    static final String LOGIN_SEQUENCE = Utils.LOGIN_PROMPT + "\n" +
            Utils.PASSWORD_PROMPT + "\n" + Utils.LOGIN_SUCCESS_MESSAGE + "\n";

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

    static void loadBooks(Library library) {
        library.add(new Book("Bosch Automotive Handbook", "Robert Bosch GmbH",
                1932));
        library.add(new Book("Clean Code", "Robert C. Martin", 2008));
        library.add(new Book("Modern Global Seismology", "Thorne Lay & Terry " +
                "C. Wallace", 1995));
        library.add(new Book("One Hundred Years of Solitude", "Gabriel Garcia " +
                "Marquez", 1967));
        library.add(new Book("Sled Driver", "Brian Shul", 1991));
    }

    static void loadMovies(Library library) {
        library.add(new Movie("Airplane!", 1980, "David Zucker, Jim Abrahams," +
                " & Jerry Zucker", "8"));
        library.add(new Movie("The Lego Movie", 2014, "Chris Miller & Phil " +
                "Lord", "8"));
        library.add(new Movie("The Pink Panther", 1963, "Blake Edwards", "7"));
    }

}
