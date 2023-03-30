package com.example.gsbandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsbandroid.Interfaces.gsbandroidService;
import com.example.gsbandroid.Models.RetrofitClientInstance;
import com.example.gsbandroid.Models.Visiteur;
import com.example.gsbandroid.databinding.ActivityMainBinding;

import java.lang.invoke.VolatileCallSite;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visiteur unVisiteur = new Visiteur(binding.editTxtUserName.getText().toString(),binding.editTxtPwd.getText().toString());
                gsbandroidService service =
                        RetrofitClientInstance.getRetrofitInstance().create(gsbandroidService.
                                class);
                Call<Visiteur> call = service.login_check(unVisiteur);
                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur>
                            response) {
                        Visiteur visiteur = response.body();
                        Toast.makeText(MainActivity.this, visiteur.getToken(),
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AccueilRdvActivity.class);
                        intent.putExtra("token", visiteur.getToken());
                        intent.putExtra("username", unVisiteur.getUsername());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}


