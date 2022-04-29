package com.github.marker99.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.github.marker99.login_firebase.data.UserRepository;

public class SettingsViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    public SettingsViewModel(@NonNull Application application) {
        super(application);

        userRepository = UserRepository.getInstance(application);
    }

    public void signOut() {
        userRepository.signOut();
    }
}
