package com.github.marker99.ui.settings;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.marker99.login_firebase.data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class SettingsViewModelImpl extends AndroidViewModel implements SettingsViewModel {

    private final UserRepository userRepository;

    public SettingsViewModelImpl(@NonNull Application application) {
        super(application);

        userRepository = UserRepository.getInstance(application);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }

    public void signOut() {
        userRepository.signOut();
    }
}
