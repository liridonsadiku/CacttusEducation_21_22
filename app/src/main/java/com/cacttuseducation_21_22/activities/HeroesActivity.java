package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.api.Api;
import com.cacttuseducation_21_22.models.Hero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesActivity extends AppCompatActivity {

    ListView heroesListView;
    ArrayList<Hero> heroesArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        heroesListView = findViewById(R.id.heroesListView);

        makeApiCallAndLoadDataIntoListView();
    }

    private void makeApiCallAndLoadDataIntoListView() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<ArrayList<Hero>>() {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response) {
                heroesArrayList = response.body();

            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t) {
                Toast.makeText(HeroesActivity.this,
                        "Something went wrong with error: " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}