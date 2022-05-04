package com.github.marker99.ui.health_inspection.specific_inspection;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionRepository;

public class SpecificHealthInspectionViewModelImpl extends AndroidViewModel implements SpecificHealthInspectionViewModel {

    //FIXME: Repository bliver aldrig brugt!
    private final HealthInspectionRepository repository;
    private HealthInspection inspection;

    public SpecificHealthInspectionViewModelImpl(Application application) {
        super(application);
        repository = HealthInspectionRepository.getInstance(application);
    }

    public void setInspection(HealthInspection inspection){
        this.inspection = inspection;
    }

    //FIXME: Bliver ikke brugt?
    public HealthInspection getInspection(){
        return inspection;
    }

}