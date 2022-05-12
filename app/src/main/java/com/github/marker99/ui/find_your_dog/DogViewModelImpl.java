package com.github.marker99.ui.find_your_dog;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.github.marker99.webservice.DogRepositoryImpl;
import com.github.marker99.webservice.model.Dog;

public class DogViewModelImpl extends ViewModel implements DogViewModel {
    DogRepositoryImpl dogRepositoryImpl;

    public DogViewModelImpl() {
        dogRepositoryImpl = DogRepositoryImpl.getInstance();
    }

    public LiveData<Dog> getRandomDog() {
        return dogRepositoryImpl.getRandomDog();
    }

    public void findRandomDog() {
        dogRepositoryImpl.findRandomDog();
    }

    public void searchForBreed(String breedName) {
        dogRepositoryImpl.searchForBreed(breedName);
    }

}