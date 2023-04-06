package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.databinding.ActivityAccueilRdv1Binding;
import com.example.gsbandroid.databinding.ActivityFichePracticienBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fiche_Practicien extends AppCompatActivity {
    private ActivityFichePracticienBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFichePracticienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gsbandroidService service =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        //manque deux argument Token et id du practiciens
        Call<Practicien> call = service.getPracById();
        call.enqueue(new Callback<Practicien>() {
            @Override
            public void onResponse(Call<Practicien> call, Response<Practicien> response) {
                Practicien practicien = response.body();
                binding.TvDrName.setText(String.valueOf(practicien.getNom().toUpperCase()));
            }

            @Override
            public void onFailure(Call<Practicien> call, Throwable t) {

            }
        });


    }
}