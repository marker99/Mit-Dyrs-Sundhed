package com.github.marker99;

import androidx.lifecycle.LiveData;

import com.google.firebase.auth.FirebaseUser;

public interface MainActivityViewModel {
    LiveData<FirebaseUser> getCurrentUser();
}
