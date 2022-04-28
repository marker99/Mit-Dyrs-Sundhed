package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DogViewModel extends ViewModel {
    DogRepositoryImpl dogRepositoryImpl;

    public DogViewModel() {
        dogRepositoryImpl = DogRepositoryImpl.getInstance();
    }

    public LiveData<Dog> getSearchedDog() {
        return dogRepositoryImpl.getRandomDog();
    }

    public void getRandomDog() {
        dogRepositoryImpl.findRandomDog();
    }

    public void searchForBreed(String s) {
        dogRepositoryImpl.searchForBreed(s);
    }

}