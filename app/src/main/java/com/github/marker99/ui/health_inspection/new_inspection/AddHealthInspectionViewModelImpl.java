package com.github.marker99.ui.health_inspection.new_inspection;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

public class AddHealthInspectionViewModelImpl extends AndroidViewModel implements AddHealthInspectionViewModel {

    private final HealthInspectionRepository repository;


    public AddHealthInspectionViewModelImpl(@NonNull Application application) {
        super(application);
        repository = HealthInspectionRepository.getInstance(application);
    }

    public void insert(final HealthInspection healthInspection){
        repository.insert(healthInspection);
    }


}