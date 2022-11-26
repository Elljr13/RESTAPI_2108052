package com.example.restapi_2018052;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon?limit=10")
    Call<Komiku> getPokemons();
}
