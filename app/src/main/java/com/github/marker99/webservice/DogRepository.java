package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;

import com.github.marker99.webservice.model.Dog;

public interface DogRepository {
    LiveData<Dog> getRandomDog();

    void searchForBreed(String breedName);

    void findRandomDog();
}
