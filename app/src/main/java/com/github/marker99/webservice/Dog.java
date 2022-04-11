package com.github.marker99.webservice;

public class Dog {

    private final String id;
    private final String imageURL;
    private String name;
    private String lifeSpan;
    private String Temperament;

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
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getTemperament() {
        return Temperament;
    }

    public void setTemperament(String temperament) {
        Temperament = temperament;
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
