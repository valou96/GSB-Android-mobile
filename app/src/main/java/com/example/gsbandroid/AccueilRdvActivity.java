package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.databinding.ActivityMainBinding;

import retrofit2.Call;

public class AccueilRdvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        private ActivityMainBinding binding;

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        gsbandroidService service =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
        Call<Visiteur> call = service.GetVisiteurs();
    }
}