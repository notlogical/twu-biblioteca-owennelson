package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Library {
    static List<Media> _allMedia;

    Library() {
        _allMedia = new LinkedList<>();
    }

    void add(Media media) {
        _allMedia.add(media);
    }

    void checkoutBook(String bookToCheckout) {
        Media media = findMedia(bookToCheckout);
        if (media != null && media.isAvailable()) {
            media.checkout();
            ConsolePrinter.printCheckoutSuccess(media.getDescriptor());
        } else {
            ConsolePrinter.printCheckoutFailure();
        }
    }

    void returnBook(String bookToReturn) {
        Media media = findMedia(bookToReturn);
        if (media != null && media.isCheckedOut()) {
            media.returnBook();
            ConsolePrinter.printReturnSuccess(media.getDescriptor());
        } else {
            ConsolePrinter.printReturnFailure();
        }
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
