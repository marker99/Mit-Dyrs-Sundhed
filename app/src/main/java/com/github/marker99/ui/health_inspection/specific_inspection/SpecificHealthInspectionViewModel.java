package com.github.marker99.ui.health_inspection.specific_inspection;

import com.github.marker99.persistence.health_inspection.HealthInspection;

public interface SpecificHealthInspectionViewModel {
    void setInspection(HealthInspection inspection);
    HealthInspection getInspection();
}
