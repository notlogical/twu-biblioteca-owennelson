package com.twu.biblioteca;

public class Movie extends Media{
    private String _director;
    private String _rating;

    Movie(String title, int year, String director, String rating) {
        super(title, year);
        _director = director;
        _rating = rating;
    }

    String getDirector() {
        return _director;
    }

    String getRating() {
        return _rating;
    }

    @Override
    boolean isMovie() {
        return true;
    }
}
