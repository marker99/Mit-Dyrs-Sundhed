package com.github.marker99.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;
import com.github.marker99.persistence.userSettings.UserSettings;
import com.github.marker99.persistence.userSettings.UserSettingsRepository;

import java.util.List;

public class HomeViewModelImpl extends AndroidViewModel implements HomeViewModel{

    private final PetRepository repository;
    private final UserSettingsRepository userSettingsRepository;

    public HomeViewModelImpl(@NonNull Application application) {
        super(application);
        repository = PetRepository.getInstance(application);
        userSettingsRepository = UserSettingsRepository.getInstance(application);
    }

    public LiveData<List<Pet>> getAllPets(){
        return repository.getAllPets();
    }

    @Override
    public void updateSettings(int petId) {
        userSettingsRepository.update(new UserSettings(petId));
    }

    @Override
    public LiveData<UserSettings> getUserSettings() {
        return userSettingsRepository.getUserSettings();
    }


}