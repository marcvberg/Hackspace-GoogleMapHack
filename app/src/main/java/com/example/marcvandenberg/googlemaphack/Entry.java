package com.example.marcvandenberg.googlemaphack;

/**
 * Created by marcvandenberg on 1/23/18.
 */

public class Entry {
    public final String title;
    public final String link;
    public final String summary;

    private Entry(String title, String summary, String link){
        this.title = title;
        this.summary = summary;
        this.link = link;
    }
}
