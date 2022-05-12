package com.github.marker99.persistence;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.pet.Pet;

import java.util.List;

// https://developer.android.com/training/data-storage/room/relationships

public class PetWithHealthInspection {
    //TODO: Dette virker ikke endnu! - Dette er ikke nødvendigt længere --> Måske bare gemme klasse i docs + comments, for potentiel fremtidig brug?
    @Embedded
    public Pet pet;
    @Relation(
            parentColumn = "id",
            entityColumn = "petId"
    )
    public List<HealthInspection> healthInspections;

}
