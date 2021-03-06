package com.github.marker99.ui.health_inspection.all_inspections_rv;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.health_inspection.HealthInspection;

import java.util.List;

public interface AllHealthInspectionsViewModel {
    LiveData<List<HealthInspection>> getAllInspectionsWithPetId(int petId);
}
