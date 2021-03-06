package com.github.marker99.ui.signalement.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;

public class SignalementViewModelImpl extends AndroidViewModel implements SignalementViewModel{

    private final PetRepository petRepository;

    public SignalementViewModelImpl(@NonNull Application application) {
        super(application);
        petRepository = PetRepository.getInstance(application);
    }

    public LiveData<Pet> getSpecificPet(int petId){
        return petRepository.getSpecificPet(petId);
    }

}