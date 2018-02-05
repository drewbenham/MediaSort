package com.example.drew.mediasort.list_models;

import java.util.ArrayList;

/**
 * Created by drew on 2/4/18.
 */

public class MediaRecords extends MediaList {
    private String artist;
    private String album;
    private String genre;

    public MediaRecords(String name, String mediaType, String artist, String album, String genre) {
        super(name, mediaType);
        this.artist = artist;
        this.album = album;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
