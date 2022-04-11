package com.github.marker99.webservice;

public class DogResponse {

    private String id;
    private String url;

    //private Dogs dogs;

    public Dog getDog() {
        return new Dog(id, url);
    }
}
