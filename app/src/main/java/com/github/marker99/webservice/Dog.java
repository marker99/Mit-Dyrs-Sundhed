package com.github.marker99.webservice;

public class Dog {

    private final String id;
    private final String imageURL;
    private String name;
    private String life_span;
    private String temperament;

    public Dog(String id, String imageURL) {
        this.id = id;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLifeSpan() {
        return life_span;
    }

    public void setLifeSpan(String lifeSpan) {
        this.life_span = lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
