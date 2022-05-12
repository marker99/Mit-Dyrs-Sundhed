package com.github.marker99.ui.health_inspection.recylerview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

import java.util.List;

public class AllHealthInspectionsViewModelImpl extends AndroidViewModel implements AllHealthInspectionsViewModel{

    private final HealthInspectionRepository repository;

    public AllHealthInspectionsViewModelImpl(Application application) {
        super(application);
        repository = HealthInspectionRepository.getInstance(application);

    }

    public LiveData<List<HealthInspection>> getAllInspections() {
        return repository.getAllInspections();
    }

    @Override
    public LiveData<List<HealthInspection>> getAllInspectionsWithPetId() {
        return repository.getAllInspectionsWithPetId();
    }

    @Override
    public void findAllInspectionsWithPetId(int petId) {
        repository.findAllInspectionsWithPetId(petId);
    }
}