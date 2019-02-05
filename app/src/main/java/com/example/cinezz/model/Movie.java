package com.example.cinezz.model;

public class Movie {
    String title;
    String releaseDate;
    Genre[] genre;
    Poster poster;
    Trailer trailer;
    Statistics statistics;

    public String getTitle() {
        return title;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
