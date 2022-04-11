package com.github.marker99.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DogAPI {

    //Why is this not needed
    //@Headers({"x-api-key: " + "a91299bb-d87d-4eee-8617-b51535425ae8"})
    @GET("v1/images/search")
    Call<DogResponse[]> getRandomDog();

}
