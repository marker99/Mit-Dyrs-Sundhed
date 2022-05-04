package com.github.marker99.ui.home;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.pet.Pet;

import java.util.List;

public interface HomeViewModel {
    LiveData<List<Pet>> getAllPets();
}
