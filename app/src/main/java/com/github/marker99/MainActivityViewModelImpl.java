package com.github.marker99;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.marker99.login_firebase.data.UserRepository;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;
import com.google.firebase.auth.FirebaseUser;

public class MainActivityViewModelImpl extends AndroidViewModel implements MainActivityViewModel {

    private final UserRepository userRepository;
    private final PetRepository petRepository;

    public MainActivityViewModelImpl(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        petRepository = PetRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }

}
