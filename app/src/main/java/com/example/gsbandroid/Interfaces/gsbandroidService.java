package com.example.gsbandroid.Interfaces;

import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.Visite;
import com.example.gsbandroid.Models.Visiteur;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface gsbandroidService {

        @POST("login_check")
        Call<Visiteur> login_check(@Body Visiteur visiteur);

        @GET("Visiteurs")
        Call<Visiteur> getVisiteurs(@Header("Authorization") String token);

}
