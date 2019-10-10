package com.twu.biblioteca;

class Command {
    private Type _type;
    private String _item;

    Command(String input) {
        parseInput(input);
    }

    String getItem() {
        return _item;
    }

    private void parseInput(String input) {
        _item = null;
        if (input.startsWith("List of books")) {
            _type = Type.LIST_BOOKS;
        } else if (input.startsWith("List of movies")) {
            _type = Type.LIST_MOVIES;
        } else if (input.startsWith("Log in")) {
            _type = Type.LOG_IN;
        } else if (input.startsWith("Log out")) {
            _type = Type.LOG_OUT;
        } else if (input.startsWith("Checkout")) {
            _type = Type.CHECKOUT;
            _item = input.replace("Checkout ", "");
        } else if (input.startsWith("Return")) {
            _type = Type.RETURN;
            _item = input.replace("Return ", "");
        } else if (input.startsWith("Quit")) {
            _type = Type.QUIT;
        } else {
            _type = Type.INVALID;
        }
    }

    Type getType() {
        return _type;
    }

    enum Type {
        LIST_BOOKS, LIST_MOVIES, LOG_IN, LOG_OUT, CHECKOUT, RETURN, QUIT, INVALID;
    }
}
