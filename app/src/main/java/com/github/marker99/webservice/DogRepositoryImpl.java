package com.github.marker99.webservice;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepositoryImpl implements DogRepository {
    private static DogRepositoryImpl instance;
    private final MutableLiveData<Dog> getRandomDog;
    private final MutableLiveData<Breed> getSpecificBreed;

    public DogRepositoryImpl() {
        getRandomDog = new MutableLiveData<>();
        getSpecificBreed = new MutableLiveData<>();
    }

    public static synchronized DogRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DogRepositoryImpl();
        }
        return instance;
    }

    public LiveData<Dog> getRandomDog() {
        return getRandomDog;
    }

    public LiveData<Breed> getSpecificBreed() {
        return getSpecificBreed;
    }

    public void searchForBreed(String breedName) {
        DogAPI dogAPI = ServiceGenerator.getDogAPI();
        Log.i("searchForBreed", breedName);
        Call<Breed[]> call = dogAPI.getBreed(breedName);
        call.enqueue(new Callback<Breed[]>() {
            @Override
            public void onResponse(Call<Breed[]> call, Response<Breed[]> response) {
                if (response.isSuccessful()) {
                    Breed breed = response.body()[0];
                    getSpecificBreed.postValue(breed);
                    Log.i("Retrofit - searchForBreed", "Something went right :) \n" + breed);
                }
            }

            @Override
            public void onFailure(Call<Breed[]> call, Throwable t) {
                Log.i("Retrofit - searchForBreed", "Something went wrong :(");
                Log.i("Retrofit - searchForBreed", t.getMessage());
            }
        });
    }

    public void findRandomDog() {
        DogAPI dogAPI = ServiceGenerator.getDogAPI();
        Call<DogResponse[]> call = dogAPI.getRandomDog();
        call.enqueue(new Callback<DogResponse[]>() {
            @Override
            public void onResponse(Call<DogResponse[]> call, Response<DogResponse[]> response) {
                if (response.isSuccessful()) {
                    Dog doggy = response.body()[0].getDog();
                    getRandomDog.postValue(doggy);
                    Log.i("Retrofit", "Something went right :) \n" + doggy);
                }
            }

            @Override
            public void onFailure(Call<DogResponse[]> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
                Log.i("Retrofit", t.getMessage());
            }
        });
    }
}
