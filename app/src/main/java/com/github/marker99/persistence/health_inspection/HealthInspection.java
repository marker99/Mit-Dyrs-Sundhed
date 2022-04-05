package com.github.marker99.persistence.health_inspection;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "healthInspection_table")
public class HealthInspection {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String inspectionDate;

    public HealthInspection(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }
}

