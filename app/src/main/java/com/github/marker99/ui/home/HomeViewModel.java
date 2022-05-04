package com.github.marker99.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.marker99.login_firebase.data.UserRepository;
import com.github.marker99.persistence.pet.Pet;
import com.github.marker99.persistence.pet.PetRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private final PetRepository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = PetRepository.getInstance(application);
    }

    public LiveData<List<Pet>> getAllPets(){
        return repository.getAllPets();
    }



}