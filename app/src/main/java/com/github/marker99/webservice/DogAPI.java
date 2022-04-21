package com.github.marker99.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface DogAPI {

    //TODO: Why is this not needed
    //@Headers({"x-api-key: " + "a91299bb-d87d-4eee-8617-b51535425ae8"})
    @GET("v1/images/search")
    Call<DogResponse[]> getRandomDog();


    @GET("v1/breeds")
    Call<DogResponse[]> getAllBreeds();

    @GET("v1/breeds/search?q={breed}")
    Call<DogResponse[]> getBreed(@Path("breed") String breed);

}
