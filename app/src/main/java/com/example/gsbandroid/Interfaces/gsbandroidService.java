package com.example.gsbandroid.Interfaces;

import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.Visite;
import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.Models.Visiteurs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface gsbandroidService {

        @POST("login_check")
        Call<Visiteur> login_check(@Body Visiteur visiteur);

        @GET("visiteurs")
        Call<Visiteurs> getVisiteurs(@Header("Authorization") String token);

        @GET("practiciens/{id}")
        Call<Practicien> getPracById(@Header("Authorization") String token, @Path("id") String Id);

        @GET("visite")
        Call<Visite> getVisite(@Header("Authorization") String token);

}
