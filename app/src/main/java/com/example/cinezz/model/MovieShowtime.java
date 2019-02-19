package com.example.cinezz.model;

import java.io.Serializable;

public class MovieShowtime implements Serializable {
    OnShow onShow;
    Version version;
    String display;
    Scr[] scr;

    public OnShow getOnShow() {
        return onShow;
    }

    public String getTitle(){
        return onShow.getMovie().getTitle();
    }

    public Statistics getStats(){
        return onShow.getMovie().getStatistics();
    }

    public Version getVersion() { return version; }

    public String getDisplay() { return display; }

    public Scr[] getScr() { return scr; }
}
