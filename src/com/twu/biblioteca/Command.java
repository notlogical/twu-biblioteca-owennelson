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
        // use matchers to assign type and then assign item if present
        _item = null;
        if (input.startsWith("List of books")) {
            _type = Type.LIST_BOOKS;
        } else if (input.startsWith("List of movies")) {
            _type = Type.LIST_MOVIES;
        } else if
    }

    Type getType() {
        return _type;
    }

    enum Type {
        LIST_BOOKS, LIST_MOVIES, LOG_IN, LOG_OUT, CHECKOUT, RETURN, QUIT, INVALID;
    }
}
