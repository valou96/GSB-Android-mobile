package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsbandroid.Adapters.RecyclerViewAdapterListPracticien;
import com.example.gsbandroid.Interfaces.RecyclerViewClickListener;
import com.example.gsbandroid.Models.Practicien;
import com.example.gsbandroid.Models.RecyclerTouchListener;
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
    private String username;
    private Visiteur visiteurAuth;
    private String pract;
    private String[] stringId;
    private RecyclerViewAdapterListPracticien adapter;
    private ArrayList<Practicien> ListPracticien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityAccueilRdv1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       Intent intent = getIntent();
       token = (String)intent.getSerializableExtra("token");
       gsbandroidService serviceTkn =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);
       username = (String)intent.getSerializableExtra("username");

       gsbandroidService serviceUsername =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);

        gsbandroidService servicePrac =
                RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                        class);

        Call<Visiteurs> callTkn = serviceTkn.getVisiteurs(token);

        ListPracticien = new ArrayList<Practicien>();
        callTkn.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
               Visiteurs visiteurs = response.body();

                for (Visiteur visiteur : visiteurs.getVisiteurs()) {
                    if (username.equals(visiteur.getUsername())){
                        visiteurAuth = visiteur;
                    }
                }

                for (String pract : visiteurAuth.getPortefeuilles() ) {
                    stringId = pract.split("/");
                    String idPrac = stringId[3];

                    Call<Practicien> callPrac = servicePrac.getPracById(token, idPrac);
                    callPrac.enqueue(new Callback<Practicien>() {
                        @Override
                        public void onResponse(Call<Practicien> call, Response<Practicien> response) {
                           Practicien unPracticien = response.body();
                           ListPracticien.add(unPracticien);
                            binding.RecyclerViewPracticien.setHasFixedSize(true);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
                            binding.RecyclerViewPracticien.setLayoutManager(layoutManager);
                            binding.RecyclerViewPracticien.setFocusable(false);
                            adapter = new RecyclerViewAdapterListPracticien(ListPracticien);
                            binding.RecyclerViewPracticien.setAdapter(adapter);
                            binding.RecyclerViewPracticien.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.RecyclerViewPracticien, new RecyclerViewClickListener() {
                                @Override
                                public void onClick(View view, int position) {
                                    String pracName = ListPracticien.get(position).getNom();
                                    Intent intent = new Intent(getApplicationContext(), FichePracticienActivity.class);
                                    intent.putExtra("token", token);
                                    intent.putExtra("username", username);
                                    intent.putExtra("idPrac", unPracticien.getId());
                                    startActivity(intent);
                                }
                            }));
                        }

                        @Override
                        public void onFailure(Call<Practicien> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {

            }
        });

  }

}