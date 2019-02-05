package com.example.cinezz.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private static ShowTimesApi showTimeApi;

    public ShowTimesApi getShowTimeApi(){return showTimeApi;}

    private ApiHelper(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://etudiants.openium.fr/pam/cine.json/").addConverterFactory(GsonConverterFactory.create())
                .build();

        showTimeApi = retrofit.create(ShowTimesApi.class);
    }

    private static volatile ApiHelper instance;


    public static synchronized ApiHelper getInstance() {
        if (instance == null) {
            instance = new ApiHelper();
        }
        return instance;
    }


}
