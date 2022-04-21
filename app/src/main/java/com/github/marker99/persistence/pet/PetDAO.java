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



}
