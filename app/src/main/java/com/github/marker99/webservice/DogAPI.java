package com.github.marker99.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogAPI {

    //TODO: Why is this not needed
    //@Headers({"x-api-key: " + "a91299bb-d87d-4eee-8617-b51535425ae8"})
    @GET("v1/images/search")
    Call<DogResponse[]> getRandomDog();


    @GET("v1/breeds")
    Call<DogResponse[]> getAllBreeds();

    //TODO: I cant figure this out
    @GET("v1/breeds/search")
    Call<DogResponse[]> getBreed(@Query("q") String breedName);


    //https://api.thedogapi.com/v1/breeds/search?q=affen
    //?q={breed}
}
