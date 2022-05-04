package com.github.marker99.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DogAPI {
    //API - https://docs.thedogapi.com/api-reference/breeds/breeds-search

    //ID VIRKER HVER GANG!!
    //https://api.thedogapi.com/v1/images/search?breed_id=1

    //TODO: Why is this not needed - Because website doesn't want you to use API key! ;) (Måske dette kunne være nyttigt i nogle af de andre cases, hvis vi vil lave andre kald?)
    //@Headers({"x-api-key: " + "a91299bb-d87d-4eee-8617-b51535425ae8"})
    @GET("v1/images/search")
    Call<DogResponse[]> getRandomDog();

    //Not in use yet
    @GET("v1/breeds")
    Call<DogResponse[]> getAllBreeds();

    //Bruges til at søge på specifik hund
    @GET("v1/breeds/search")
    Call<Breed[]> getBreed(@Query("name") String breedName);

    //Bruges til at finde billede på querying ovenover!
    @GET("v1/images/{image}")
    Call<DogImage> getDogImage(@Path("image") String image);
}
