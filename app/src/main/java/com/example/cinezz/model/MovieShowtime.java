package com.example.cinezz.model;

public class MovieShowtime {
    OnShow onShow;
    Version version;
    String display;

    public OnShow getOnShow() {
        return onShow;
    }

    public String getTitle(){
        return onShow.getMovie().getTitle();
    }

    public Statistics getStats(){
        return onShow.getMovie().getStatistics();
    }
}
