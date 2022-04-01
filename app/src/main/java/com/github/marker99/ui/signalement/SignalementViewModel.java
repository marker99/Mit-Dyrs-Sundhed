package com.github.marker99.ui.signalement;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignalementViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SignalementViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dum");
    }

    public LiveData<String> getText() {
        return mText;
    }
}