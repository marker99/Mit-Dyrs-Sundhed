package com.github.marker99.ui.find_your_dog;

import androidx.lifecycle.LiveData;

import com.github.marker99.webservice.model.Dog;

public interface DogViewModel {
    LiveData<Dog> getRandomDog();
    void findRandomDog();
    void searchForBreed(String breedName);
}
