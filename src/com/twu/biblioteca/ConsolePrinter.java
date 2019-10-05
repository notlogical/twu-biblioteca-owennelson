package com.twu.biblioteca;
import java.util.List;

public class ConsolePrinter {
    private static int fieldWidth = 30;

    public static void printWelcome() {
        System.out.println(Utils.WELCOME_TEXT);
    }

    public static void printOptions() {
        System.out.println(Utils.OPTION_LIST);
    }

    public static void printBookList(List<Book> books) {
        for (Book book : books) {
            printBook(book);
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
        return text.format("%-" + fieldWidth + "s", text);
    }
}
