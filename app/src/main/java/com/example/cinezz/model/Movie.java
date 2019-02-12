package com.example.cinezz.model;

import java.io.Serializable;

public class Movie implements Serializable {
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
