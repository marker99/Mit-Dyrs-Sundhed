package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;

public interface DogViewModel {
    LiveData<Dog> getRandomDog();
    void findRandomDog();
    void searchForBreed(String breedName);
}
