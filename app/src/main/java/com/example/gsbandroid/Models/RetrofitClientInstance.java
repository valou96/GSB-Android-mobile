package com.example.gsbandroid.Models;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://127.0.0.1:8000/api/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}