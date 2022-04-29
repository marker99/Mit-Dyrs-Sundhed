package com.github.marker99.login_firebase.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseUser;


public class UserRepository {

    private final UserLiveData currentUser;
    private final Application application;
    private static UserRepository instance;


    public UserRepository(Application application) {
        this.application = application;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app) {
        if (instance == null)
            instance = new UserRepository(app);
        return instance;
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return currentUser;
    }

    public void signOut() {
        AuthUI.getInstance().signOut(application.getApplicationContext());
    }


}
