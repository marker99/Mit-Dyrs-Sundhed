package com.github.marker99.webservice;

public class Dog {

    private final String id;
    private final String imageURL;

    public Dog(String id, String imageURL) {
        this.id = id;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

}
