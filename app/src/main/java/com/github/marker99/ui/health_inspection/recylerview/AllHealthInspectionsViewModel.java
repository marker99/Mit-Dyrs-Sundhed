package com.github.marker99.ui.health_inspection.recylerview;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.health_inspection.HealthInspection;

import java.util.List;

public interface AllHealthInspectionsViewModel {
    LiveData<List<HealthInspection>> getAllInspections();
    LiveData<List<HealthInspection>> getAllInspectionsWithPetId();

    void findAllInspectionsWithPetId(int petId);

}
