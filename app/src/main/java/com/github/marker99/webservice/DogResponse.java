package com.github.marker99.webservice;

public class DogResponse {

    private String id;
    private String url;

    private Breeds[] breeds;

    public Dog getDog() {
        Dog newDog = new Dog(id, url);
        if (breeds.length != 0) {
            newDog.setName(breeds[0].name);
            newDog.setLifeSpan(breeds[0].life_span);
            newDog.setTemperament(breeds[0].temperament);
        } else {
            newDog.setName("Breed Unknown");
            newDog.setLifeSpan("Unknown");
            newDog.setTemperament("Unknown");
        }
        return newDog;
    }

    private class Breeds {
        private String name;
        private String life_span;
        private String temperament;
    }

}
