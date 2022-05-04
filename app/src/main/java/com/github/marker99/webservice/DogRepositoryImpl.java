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
    private DogAPI dogAPI;

    public DogRepositoryImpl() {
        getRandomDog = new MutableLiveData<>();
        dogAPI = ServiceGenerator.getDogAPI();
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

    public void searchForBreed(String breedName) {
        dogAPI = ServiceGenerator.getDogAPI();
        Log.i("Retrofit", "Start (searchForBreed) - Breed: " +  breedName);
        Call<Breed[]> call = dogAPI.getBreed(breedName);
        call.enqueue(new Callback<Breed[]>() {
            @Override
            public void onResponse(Call<Breed[]> call, Response<Breed[]> response) {
                if (response.isSuccessful()) {
                    Breed breed = response.body()[0];

                    //Setting picture and converting to Dog!
                    setBreedPicture(breed);
                }
            }
            @Override
            public void onFailure(Call<Breed[]> call, Throwable t) {
                Log.i("Retrofit", "FAILURE (searchForBreed)"
                        +"\nError Message: " + t.getMessage());
            }
        });
    }

    private void setBreedPicture(Breed breed) {
        //Bruges til at lave breed om til en Dog, ved at tilføje Image
        Call<DogImage> call = dogAPI.getDogImage(breed.getBreedUrl());
        call.enqueue(new Callback<DogImage>() {
            @Override
            public void onResponse(Call<DogImage> call, Response<DogImage> response) {
                if (response.isSuccessful()) {
                    DogImage image = response.body();
                    Dog dog = new Dog(image.getId(), image.getUrl());
                    dog.setLifeSpan(breed.getLifeSpan());
                    dog.setName(breed.getName());
                    dog.setTemperament(breed.getTemperament());
                    getRandomDog.postValue(dog);
                }
            }

            @Override
            public void onFailure(Call<DogImage> call, Throwable t) {
                Log.i("Retrofit", "FAILURE (setBreedPicture)"
                        +"\nError Message: " + t.getMessage());
            }
        });

    }

    public void findRandomDog() {
        dogAPI = ServiceGenerator.getDogAPI();
        Call<DogResponse[]> call = dogAPI.getRandomDog();
        call.enqueue(new Callback<DogResponse[]>() {
            @Override
            public void onResponse(Call<DogResponse[]> call, Response<DogResponse[]> response) {
                if (response.isSuccessful()) {
                    Dog doggy = response.body()[0].getDog();
                    getRandomDog.postValue(doggy);
                    Log.i("Retrofit", "SUCCESS\n" + doggy);
                }
            }

            @Override
            public void onFailure(Call<DogResponse[]> call, Throwable t) {
                Log.i("Retrofit", "FAILURE (findRandomDog)"
                        +"\nError Message: " + t.getMessage());
            }
        });
    }
}
