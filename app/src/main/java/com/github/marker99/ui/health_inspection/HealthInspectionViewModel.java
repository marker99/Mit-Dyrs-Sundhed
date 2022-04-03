package com.github.marker99.ui.health_inspection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HealthInspectionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HealthInspectionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}