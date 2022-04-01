package com.github.marker99.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.github.marker99.Pet;

@Database(entities = {Pet.class}, version = 1)
public abstract class PetDatabase extends RoomDatabase {

    private static PetDatabase instance;
    public abstract PetDAO petDAO();

    public static synchronized PetDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context,
                    PetDatabase.class, "pet_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
