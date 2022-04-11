package com.github.marker99.ui.health_inspection.recylerview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

import java.util.List;

public class AllHealthInspectionsViewModel extends AndroidViewModel {

    private final HealthInspectionRepository repository;

    public AllHealthInspectionsViewModel(Application application) {
        super(application);
        repository = HealthInspectionRepository.getInstance(application);

    }

    public LiveData<List<HealthInspection>> getAllInspections() {
        return repository.getAllInspections();
    }
}