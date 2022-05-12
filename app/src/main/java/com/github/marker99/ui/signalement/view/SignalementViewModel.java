package com.github.marker99.ui.signalement.view;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.pet.Pet;

public interface SignalementViewModel {
    LiveData<Pet> getSpecificPet(int petId);
}
