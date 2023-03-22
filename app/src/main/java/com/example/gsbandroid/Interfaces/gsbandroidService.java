package com.example.gsbandroid.Interfaces;

import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.Visite;
import com.example.gsbandroid.Models.Visiteur;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface gsbandroidService {

        @POST("login_check")
        Call<Visiteur> getVisiteur();

}
