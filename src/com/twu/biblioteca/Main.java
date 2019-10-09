package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        Library theLibrary = new Library();
        loadBooks(theLibrary);
        loadMovies(theLibrary);
        new BibliotecaApp(theLibrary).main(null);
    }

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
