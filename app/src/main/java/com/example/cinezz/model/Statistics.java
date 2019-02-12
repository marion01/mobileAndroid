package com.example.cinezz.model;

import java.io.Serializable;

public class Statistics implements Serializable {
    String pressRating;
    String userRating;

    public String getPressRating() {
        return pressRating;
    }

    public String getUserRating() {
        return userRating;
    }
}
