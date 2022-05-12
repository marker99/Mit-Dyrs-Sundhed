package com.github.marker99.ui.growth_track;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.github.marker99.persistence.pet.PetRepository;

public class GrowthTrackViewModelImpl extends AndroidViewModel implements GrowthTrackViewModel {
    private final PetRepository petRepository;

    public GrowthTrackViewModelImpl(@NonNull Application application) {
        super(application);
        petRepository = PetRepository.getInstance(application);
    }


    // TODO: Implement the ViewModel
}