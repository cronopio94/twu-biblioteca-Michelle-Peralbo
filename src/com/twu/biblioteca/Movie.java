package com.twu.biblioteca;

public class Movie {
    private static int numberOfBooks;
    private int id;
    private String name;
    private int year;
    private String director;
    private int movieRating;

    public Movie(String name, int year, String director, int movieRating) {
        numberOfBooks++;
        this.id = numberOfBooks;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + year + "\t" + director + "\t" + movieRating;
    }
}
