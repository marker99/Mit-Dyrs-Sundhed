package com.github.marker99.persistence.health_inspection;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface HealthInspectionDAO {

    @Insert
    void insert(HealthInspection healthInspection);

    @Update
    void update(HealthInspection healthInspection);

    @Delete
    void delete(HealthInspection healthInspection);


    @Query("DELETE FROM healthInspection_table")
    void deleteAllInspections();

    @Query("SELECT * FROM healthInspection_table ORDER BY inspectionDate DESC")
    LiveData<List<HealthInspection>> getAllInspections();

}



