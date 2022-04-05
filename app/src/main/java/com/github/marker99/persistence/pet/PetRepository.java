package com.github.marker99.persistence.pet;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.github.marker99.persistence.Database;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PetRepository {

    private static PetRepository instance;
    private final PetDAO petDAO;
    private final LiveData<List<Pet>> allPets;
    private final ExecutorService executorService;

    private PetRepository(Application application) {
        Database database = Database.getInstance(application);
        petDAO = database.petDAO();
        allPets = petDAO.getAllPets();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized PetRepository getInstance(Application application) {
        if (instance == null)
            instance = new PetRepository(application);

        return instance;
    }

    public LiveData<List<Pet>> getAllPets() {
        return allPets;
    }

    public void insert(Pet pet) {
        executorService.execute(() -> petDAO.insert(pet));
    }

    public void deleteAllPets() {
        executorService.execute(petDAO::deleteAllPets);
    }

}
