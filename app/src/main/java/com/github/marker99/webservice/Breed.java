package com.github.marker99.webservice;

public class Breed {
    private String name;
    private String lifeSpan;
    private String Temperament;

    public Breed(String name, String lifeSpan, String temperament) {
        this.name = name;
        this.lifeSpan = lifeSpan;
        Temperament = temperament;
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
        return "Breed{" +
                "name='" + name + '\'' +
                ", lifeSpan='" + lifeSpan + '\'' +
                ", Temperament='" + Temperament + '\'' +
                '}';
    }
}
