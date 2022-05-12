package com.github.marker99.persistence.pet;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PetDAO {

    @Insert
    void insert(Pet pet);

    @Update
    void update(Pet pet);


    //TODO: FUTURE
    @Delete
    void delete(Pet pet);

    //Denne metode giver nu en liste i Home, der skal bruges til at søge efter et specifikt pet!
    @Query("SELECT * FROM pet_table ORDER BY petName DESC")
    LiveData<List<Pet>> getAllPets();

    @Query("SELECT * FROM pet_table WHERE id = :petId")
    LiveData<Pet> getSpecificPet(int petId);


    /*
     a method to the DAO class that returns all instances of the data class that pairs the parent entity
     and the child entity. This method requires Room to run two queries,
     so add the @Transaction annotation to this method to ensure that the whole operation is performed automatically

     Dette er ikke nødvendigt, hvis vi ikke vil hive data op med både Pet og Pet Inspection på samme tid!

     @Transaction
     @Query("SELECT * FROM pet_table")
     LiveData<List<PetWithHealthInspection>> getPetsAndHealthInspections();
     */


}
