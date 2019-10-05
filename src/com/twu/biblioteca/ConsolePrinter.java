package com.twu.biblioteca;
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

    static void printBookList(List<Book> books) {
        for (Book book : books) {
            if (book.isAvailable()) {
                printBook(book);
            }
        }
    }

    private static void printBook(Book book) {
        System.out.println(fitText(book.getTitle()) + "|" + fitText(book
                .getAuthor()) + "|" + book.getYear());
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
