package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DogViewModelImpl extends ViewModel {
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