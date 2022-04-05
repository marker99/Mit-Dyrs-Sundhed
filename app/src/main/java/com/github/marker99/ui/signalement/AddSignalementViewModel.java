package com.github.marker99.ui.signalement;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;


public class AddSignalementViewModel extends AndroidViewModel {

    private final PetRepository repository;

    public AddSignalementViewModel(@NonNull Application application) {
        super(application);
        repository = PetRepository.getInstance(application);
    }

    public void insert(final Pet pet){
        repository.insert(pet);
    }

}
