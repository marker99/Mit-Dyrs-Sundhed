package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;

public interface DogRepository {
    LiveData<Dog> getRandomDog();

    LiveData<Breed> getSpecificBreed();

    void searchForBreed(String breedName);

    void findRandomDog();
}
