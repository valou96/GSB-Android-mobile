package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.gsbandroid.Adapters.RecyclerViewAdapterListPracticien;
import com.example.gsbandroid.Adapters.RecyclerViewAdapterListVisite;
import com.example.gsbandroid.Interfaces.RecyclerViewClickListener;
import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.RecyclerTouchListener;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.Models.Visite;
import com.example.gsbandroid.databinding.ActivityAccueilRdv1Binding;
import com.example.gsbandroid.databinding.ActivityFichePracticienBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FichePracticienActivity extends AppCompatActivity {
    private ActivityFichePracticienBinding binding;
    private String token;
    private int idPrac;
    private String idPracStr;
    private ArrayList<String> listVisite;
    private RecyclerViewAdapterListVisite adapter;
    private Visite uneVisite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFichePracticienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gsbandroidService service =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        Intent intent = getIntent();
        token = (String)intent.getSerializableExtra("token");
        gsbandroidService serviceTkn =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        idPrac = (int)intent.getSerializableExtra("idPrac");
        idPracStr = String.valueOf(idPrac);
        gsbandroidService serviceIdPrac =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        Call<Practicien> call = service.getPracById(token, idPracStr);


        call.enqueue(new Callback<Practicien>() {
            @Override
            public void onResponse(Call<Practicien> call, Response<Practicien> response) {
                Practicien unPracticien = response.body();
                binding.TvPrenomPracticien.setText(String.valueOf(unPracticien.getNom().toUpperCase()));
                binding.TvPrenom1Practicien.setText(String.valueOf(unPracticien.getPrenom().toUpperCase()));
                binding.TvAdresse1Practicien.setText(String.valueOf(unPracticien.getAdresse().toUpperCase()));
                binding.TvCp1Practicien.setText(String.valueOf(unPracticien.getCp().toUpperCase()));
                binding.TvVille1Practicien.setText(String.valueOf(unPracticien.getVille().toUpperCase()));
                binding.TvTelephone1Practicien.setText(String.valueOf(unPracticien.getTel().toUpperCase()));
                binding.TvEmail1Practicien.setText(String.valueOf(unPracticien.getMail().toUpperCase()));
                binding.TvCoef1Practicien.setText(String.valueOf(unPracticien.getCoefNotoriete()));
/*
                uneVisite = unPracticien.getVisites();
                listVisite.add(uneVisite);
                binding.RecyclerViewVisite.setHasFixedSize(true);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                binding.RecyclerViewVisite.setLayoutManager(layoutManager);
                binding.RecyclerViewVisite.setFocusable(false);
                adapter = new RecyclerViewAdapterListPracticien(listVisite);
                binding.RecyclerViewVisite.setAdapter(adapter);

 */
            }
            @Override
            public void onFailure(Call<Practicien> call, Throwable t) {

            }

        });
    }
}