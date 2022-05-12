package com.github.marker99.webservice.model;

public class DogImage {
    private String url;
    private String id;

    public DogImage(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
