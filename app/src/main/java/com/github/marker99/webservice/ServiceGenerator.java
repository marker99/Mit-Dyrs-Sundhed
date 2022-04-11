package com.github.marker99.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static DogAPI dogAPI;

    public static DogAPI getDogAPI() {
        if (dogAPI == null) {
            dogAPI = new Retrofit.Builder()
                    .baseUrl("https://api.thedogapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DogAPI.class);
        }
        return dogAPI;

    }
}
