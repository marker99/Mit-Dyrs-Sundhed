package com.github.marker99.persistence.pet;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.github.marker99.persistence.PetWithHealthInspection;

import java.util.List;

@Dao
public interface PetDAO {

    @Insert
    void insert(Pet pet);

    @Update
    void update(Pet pet);

    @Delete
    void delete(Pet pet);

    @Query("DELETE FROM pet_table")
    void deleteAllPets();

    //TODO: Maybe change or make new method to only take a specific pet
    @Query("SELECT * FROM pet_table ORDER BY petName DESC")
    LiveData<List<Pet>> getAllPets();


    //TODO: rigtig grim løsning - ændre på et tidspunkt
    @Query("SELECT * FROM pet_table WHERE id = 1")
    LiveData<Pet> getSpecificPet();


    /*
     a method to the DAO class that returns all instances of the data class that pairs the parent entity
     and the child entity. This method requires Room to run two queries,
     so add the @Transaction annotation to this method to ensure that the whole operation is performed atomically
     */
    //TODO: Spørg Kasper om dette, hvordan vil vi mappe pets og health inspections? (Man kunne have gemt det petid man har valgt,
    // og bare lave health inspections på det, samt trække op fra health inspections på dette Pet)
    // - Dette vil dog ikke rigtigt gøre brug af dette under?
    @Transaction
    @Query("SELECT * FROM pet_table")
    LiveData<List<PetWithHealthInspection>> getPetsAndHealthInspections();


}
