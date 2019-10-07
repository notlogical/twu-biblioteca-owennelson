package com.twu.biblioteca;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.List;

class ConsolePrinter {
    private static int fieldWidth = 30;

    static void printWelcome() {
        System.out.println(Utils.WELCOME_MESSAGE);
    }

    static void printOptions() {
        System.out.println(Utils.OPTION_LIST);
    }

    static void printInvalidOptionWarning() {
        System.out.println(Utils.INVALID_OPTION_MESSAGE);
    }

    static void printCheckoutSuccess(String descriptor) {
        System.out.println("Thank you! Enjoy the " + descriptor);
    }

    static void printCheckoutFailure() {
        System.out.println(Utils.FAILED_CHECKOUT_MESSAGE);
    }

    static void printLoginToCheckout() {
        System.out.println(Utils.LOGIN_CHECKOUT_MESSAGE);
    }

    static void printReturnSuccess(String descriptor) {
        System.out.println("Thank you for returning the " + descriptor);
    }

    static void printReturnFailure() {
        System.out.println(Utils.FAILED_RETURN_MESSAGE);
    }

    static void printLoginToReturn() {
        System.out.println(Utils.LOGIN_RETURN_MESSAGE);
    }

    static void printBookList(List<Media> allMedia) {
        for (Media book : allMedia) {
            if (book.isBook() && book.isAvailable()) {
                printBook((Book) book);
            }
        }
    }

    private static void printBook(Book book) {
        System.out.println(fitText(book.getTitle()) + "|" + fitText(book
                .getAuthor()) + "|" + book.getYear());
    }

    static void printMovieList(List<Media> allMedia) {
        for (Media movie : allMedia) {
            if (movie.isMovie() && movie.isAvailable()) {
                printMovie((Movie) movie);
            }
        }
    }

    static void printMovie(Movie movie) {
        System.out.println(fitText(movie.getTitle()) + "|" + movie.getYear() +
        "|" + fitText(movie.getDirector()) + "|" + movie.getRating());
    }

    private static String fitText(String text) {
        if (text.length() > fieldWidth) {
            return trimText(text);
        } else {
            return padText(text);
        }
    }

    private static String trimText(String text) {
        return text.substring(0, fieldWidth - 3) + "...";
    }

    private static String padText(String text) {
        return String.format("%-" + fieldWidth + "s", text);
    }
}
