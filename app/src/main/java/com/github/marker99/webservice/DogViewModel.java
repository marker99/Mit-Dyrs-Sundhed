package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DogViewModel extends ViewModel {
    DogRepositoryImpl dogRepositoryImpl;

    public DogViewModel() {
        dogRepositoryImpl = DogRepositoryImpl.getInstance();
    }

    public LiveData<Dog> getRandomDog() {
        return dogRepositoryImpl.getRandomDog();
    }

    /*
    public LiveData<Breed> getSpecificBreed(){
        return dogRepositoryImpl.getSpecificBreed();
    }*/

    public void findRandomDog() {
        dogRepositoryImpl.findRandomDog();
    }

    public void searchForBreed(String s) {
        dogRepositoryImpl.searchForBreed(s);
    }

}