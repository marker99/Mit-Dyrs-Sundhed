package com.github.marker99.ui.signalement.add;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;


public class AddSignalementViewModelImpl extends AndroidViewModel implements AddSignalementViewModel{

    private final PetRepository repository;

    public AddSignalementViewModelImpl(@NonNull Application application) {
        super(application);
        repository = PetRepository.getInstance(application);
    }

    public void insert(Pet pet){
        repository.insert(pet);
    }

}
