package com.github.marker99.webservice;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepository {
    private static DogRepository instance;
    private final MutableLiveData<Dog> searchedBreed;

    public DogRepository() {
        searchedBreed = new MutableLiveData<>();
    }

    public static synchronized DogRepository getInstance() {
        if (instance == null) {
            instance = new DogRepository();
        }
        return instance;
    }

    public LiveData<Dog> getSearchedBreed() {
        return searchedBreed;
    }


    public void getRandomDog() {
        DogAPI dogAPI = ServiceGenerator.getDogAPI();
        Call<DogResponse[]> call = dogAPI.getRandomDog();
        call.enqueue(new Callback<DogResponse[]>() {
            @Override
            public void onResponse(Call<DogResponse[]> call, Response<DogResponse[]> response) {
                if (response.isSuccessful()) {
                    Dog doggy = response.body()[0].getDog();
                    searchedBreed.setValue(doggy);
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
