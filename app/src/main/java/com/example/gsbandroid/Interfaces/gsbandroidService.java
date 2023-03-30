package com.example.gsbandroid.Interfaces;

import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.Models.Visiteurs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface gsbandroidService {

        @POST("login_check")
        Call<Visiteur> login_check(@Body Visiteur visiteur);

        @GET("visiteurs")
        Call<Visiteurs> getVisiteurs(@Header("Authorization") String token);

}
