package com.github.marker99.ui.health_inspection.recylerview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

import java.util.List;

public class AllHealthInspectionsViewModelImpl extends AndroidViewModel implements AllHealthInspectionsViewModel{

    private final HealthInspectionRepository repository;

    public AllHealthInspectionsViewModelImpl(Application application) {
        super(application);
        repository = HealthInspectionRepository.getInstance(application);

    }

    @Override
    public LiveData<List<HealthInspection>> getAllInspectionsWithPetId(int petId) {
        return repository.getAllInspectionsWithPetId(petId);
    }
}