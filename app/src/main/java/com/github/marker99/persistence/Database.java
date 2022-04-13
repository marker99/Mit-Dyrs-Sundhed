package com.github.marker99.persistence;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionDAO;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetDAO;

@androidx.room.Database(entities = {Pet.class, HealthInspection.class}, version = 3)
@TypeConverters({DateConverter.class})
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract PetDAO petDAO();
    public abstract HealthInspectionDAO inspectionDAO();

    public static synchronized Database getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    Database.class, "pet_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
