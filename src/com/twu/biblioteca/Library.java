package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Library {
    static List<Media> _allMedia;

    Library() {
        _allMedia = new LinkedList<>();
    }

    void add(Media media) {
        _allMedia.add(media);
    }

    void checkoutBook(String bookToCheckout, User user) {
        Media media = findMedia(bookToCheckout);
        if (media != null && media.isAvailable()) {
            media.checkout(user);
            ConsolePrinter.printCheckoutSuccess(media.getDescriptor());
        } else {
            ConsolePrinter.printCheckoutFailure();
        }
    }

    void returnBook(String bookToReturn, User user) {
        Media media = findMedia(bookToReturn);
        if (media != null && media.isCheckedOut()) {
            media.returnItem(user);
            ConsolePrinter.printReturnSuccess(media.getDescriptor());
        } else {
            ConsolePrinter.printReturnFailure();
        }
    }

    Set<User> getHolders(String item) {
        return findMedia(item).getHolders();
    }

    private static Media findMedia(String mediaToFind) {
        for (Media media : _allMedia) {
            if (media.getTitle().equals(mediaToFind)) {
                return media;
            }
        }
        return null;
    }
}
