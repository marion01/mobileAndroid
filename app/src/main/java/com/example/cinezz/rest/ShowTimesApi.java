package com.example.cinezz.rest;

import com.example.cinezz.model.Global;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShowTimesApi {
    @GET("https://etudiants.openium.fr/pam/cine.json")
    Call<Global> getGlobal();
}
