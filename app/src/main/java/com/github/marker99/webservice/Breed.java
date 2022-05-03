package com.github.marker99.webservice;

public class Breed {
    private String name;
    private String life_span;
    private String temperament;
    private String reference_image_id;

    public Breed(String name, String life_span, String temperament, String reference_image_id) {
        this.name = name;
        this.life_span = life_span;
        this.temperament = temperament;
        this.reference_image_id = reference_image_id;
    }

    public String getBreedUrl() {
        return reference_image_id;
    }

    public void setBreedUrl(String breed_url) {
        this.reference_image_id = breed_url;
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
                ", life_span='" + life_span + '\'' +
                ", temperament='" + temperament + '\'' +
                ", reference_image_id='" + reference_image_id + '\'' +
                '}';
    }
}
