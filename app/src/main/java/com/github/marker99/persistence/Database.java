package com.github.marker99.persistence;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.github.marker99.persistence.health_inspection.HealthInspection;
import com.github.marker99.persistence.health_inspection.HealthInspectionDAO;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetDAO;
import com.github.marker99.persistence.userSettings.UserSettings;
import com.github.marker99.persistence.userSettings.UserSettingsDAO;

@androidx.room.Database(entities = {Pet.class, HealthInspection.class, UserSettings.class}, version = 8)
@TypeConverters({DateHandler.class})
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract PetDAO petDAO();
    public abstract HealthInspectionDAO inspectionDAO();
    public abstract UserSettingsDAO userSettingsDAO();

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
