package com.github.marker99.webservice;

public class Breed {
    private String name;
    private String life_span;
    private String temperament;

    public Breed(String name, String life_span, String temperament) {
        this.name = name;
        this.life_span = life_span;
        this.temperament = temperament;
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

    public void setLifeSpan(String life_span) {
        this.life_span = life_span;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                ", lifeSpan='" + life_span + '\'' +
                ", Temperament='" + temperament + '\'' +
                '}';
    }
}
