package com.github.marker99.ui.settings;

import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;

public interface SettingsViewModel {
    LiveData<FirebaseUser> getCurrentUser();
    void signOut();
}
