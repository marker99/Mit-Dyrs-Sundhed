package com.github.marker99.webservice;

public class DogResponse {

    private String id;
    private String url;

    private Breed[] breeds;

    public Dog getDog() {
        Dog newDog = new Dog(id, url);
        if (breeds != null && breeds.length != 0) {
            newDog.setName(breeds[0].getName());
            newDog.setLifeSpan(breeds[0].getLifeSpan());
            newDog.setTemperament(breeds[0].getTemperament());
        } else {
            newDog.setName("Breed Unknown");
            newDog.setLifeSpan("Unknown");
            newDog.setTemperament("Unknown");
        }
        return newDog;
    }


}
