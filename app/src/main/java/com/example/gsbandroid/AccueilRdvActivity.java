package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gsbandroid.Adapters.RecyclerViewAdapterListPracticien;
import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.Models.Visiteurs;
import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.databinding.ActivityAccueilRdv1Binding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccueilRdvActivity extends AppCompatActivity {
    private ActivityAccueilRdv1Binding binding;
    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_rdv1);
        binding = ActivityAccueilRdv1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       Intent intent = getIntent();
       token = (String)intent.getSerializableExtra("token");
        gsbandroidService service =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        Call<Visiteurs> call = service.getVisiteurs(token);
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
               Visiteurs visiteur = response.body();
               RecyclerViewAdapterListPracticien adapterListPracticien = new RecyclerViewAdapterListPracticien(visiteur.getVisiteursr());
                binding.RvPracticien.setAdapter(adapterListPracticien);
            }


            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {

            }
        });
  }
}