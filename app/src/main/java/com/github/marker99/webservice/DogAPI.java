package com.github.marker99.webservice;

import com.github.marker99.webservice.model.Breed;
import com.github.marker99.webservice.model.DogImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogAPI {
    //API Dokumentation - https://docs.thedogapi.com/api-reference/breeds/breeds-search

    @Headers({"x-api-key: " + "a91299bb-d87d-4eee-8617-b51535425ae8"})

    @GET("v1/images/search")
    Call<DogResponse[]> getRandomDog();

    //Not in use yet - For a spinner perhaps! (172 hunde i API'en)
    @GET("v1/breeds")
    Call<DogResponse[]> getAllBreeds();

    //Bruges til at søge på specifik hund
    @GET("v1/breeds/search")
    Call<Breed[]> getBreed(@Query("name") String breedName);

    //Bruges til at finde billede på querying ovenover!
    @GET("v1/images/{image}")
    Call<DogImage> getDogImage(@Path("image") String image);
}
