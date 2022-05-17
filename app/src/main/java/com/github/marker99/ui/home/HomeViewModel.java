package com.github.marker99.ui.home;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.userSettings.UserSettings;

import java.util.List;

public interface HomeViewModel {
    LiveData<List<Pet>> getAllPets();
    void updateSettings(int petId);
    LiveData<UserSettings> getUserSettings();
}
