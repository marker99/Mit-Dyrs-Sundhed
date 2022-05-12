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

    //FUTURE - DELETE PET!
    @Delete
    void delete(Pet pet);

    //Denne metode giver nu en liste i Home, der skal bruges til at søge efter et specifikt pet!
    @Query("SELECT * FROM pet_table ORDER BY petName DESC")
    LiveData<List<Pet>> getAllPets();

    @Query("SELECT * FROM pet_table WHERE id = :petId")
    LiveData<Pet> getSpecificPet(int petId);
    }
