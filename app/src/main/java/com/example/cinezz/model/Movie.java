package com.example.cinezz.model;

import java.io.Serializable;

public class Movie implements Serializable {
    String title;
    Release release;
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

    public String getGenre() {
        String str = "";
        for (Genre g : genre) {
            if (str != "")
                str += ", ";
            str += g.getName();
        }
        return str;
    }

    public Release getRelease() { return release; }
    public String getReleaseDate() { return release.getReleaseDate(); }

    public String getPoster() { return poster.getHref(); }

    public String getTrailer(){ return trailer.getHref();}
}
