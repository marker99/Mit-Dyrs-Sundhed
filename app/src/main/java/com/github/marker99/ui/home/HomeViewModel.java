package com.github.marker99.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.marker99.login_firebase.data.UserRepository;

public class HomeViewModel extends AndroidViewModel {

    private final MutableLiveData<String> mText;


    public HomeViewModel(@NonNull Application application) {
        super(application);

        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}