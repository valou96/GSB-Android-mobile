package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.databinding.ActivityAccueilRdv1Binding;
import com.example.gsbandroid.databinding.ActivityFichePracticienBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FichePracticienActivity extends AppCompatActivity {
    private ActivityFichePracticienBinding binding;
    private String token;
    private int idPrac;
    private String idPracStr;
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
                Practicien practicien = response.body();
                binding.TvPrenom1Practicien.setText(String.valueOf(practicien.getNom().toUpperCase()));
                binding.TvAdresse1Practicien.setText(String.valueOf(practicien.getPrenom().toUpperCase()));
                binding.TvCp1Practicien.setText(String.valueOf(practicien.getCp().toUpperCase()));
                binding.TvVille1Practicien.setText(String.valueOf(practicien.getVille().toUpperCase()));
                binding.TvTelephone1Practicien.setText(String.valueOf(practicien.getTel().toUpperCase()));
                binding.TvEmail1Practicien.setText(String.valueOf(practicien.getMail().toUpperCase()));
                binding.TvCoef1Practicien.setText(String.valueOf(practicien.getCoefNotoriete()));

            }

            @Override
            public void onFailure(Call<Practicien> call, Throwable t) {

            }
        });


    }
}