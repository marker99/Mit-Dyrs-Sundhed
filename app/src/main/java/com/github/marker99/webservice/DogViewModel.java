package com.github.marker99.webservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DogViewModel extends ViewModel {
    DogRepository dogRepository;

    public DogViewModel() {
        dogRepository = DogRepository.getInstance();
    }

    public LiveData<Dog> getSearchedDog() {
        return dogRepository.getSearchedBreed();
    }

    public void getRandomDog() {
        dogRepository.getRandomDog();
    }

    public void searchForBreed(String s) {
        dogRepository.searchForBreed(s);
    }

}