package com.github.marker99.ui.growth_track;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.github.marker99.persistence.pet.PetRepository;

public class GrowthTrackViewModel extends AndroidViewModel {
    private final PetRepository petRepository;

    public GrowthTrackViewModel(@NonNull Application application) {
        super(application);
        petRepository = PetRepository.getInstance(application);
    }


    // TODO: Implement the ViewModel
}