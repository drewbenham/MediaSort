package com.example.drew.mediasort.list_models;

/**
 * Created by drew on 2/4/18.
 */

public class MediaList {

    private String name;
    private String mediaType;

    public MediaList() {
        name = "Blank List";
        mediaType = "N/A";
    }

    public MediaList(String name, String mediaType) {
        this.name = name;
        this.mediaType = mediaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
