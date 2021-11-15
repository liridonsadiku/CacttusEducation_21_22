package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.adapters.WeatherAdapter;
import com.cacttuseducation_21_22.models.Weather;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    ListView weatherListView;
    ArrayList<Weather> weatherArrayList = new ArrayList<>();
    WeatherAdapter weatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        weatherListView = findViewById(R.id.weatherListView);

        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Prishtina", "Raining", "3°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Gjilani", "Snowing", "1°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Peja", "Raining", "2°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Prizreni", "Snowing", "4°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Gjakova", "Raining", "2°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Mitrovica", "Snowing", "3°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Decani", "Raining", "4°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Lipjani", "Snowing", "1°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Drenasi", "Raining", "2°C"));
        weatherArrayList.add(new Weather(R.mipmap.ic_launcher, "Podujeva", "Snowing", "1°C"));


        weatherAdapter = new WeatherAdapter(WeatherActivity.this,weatherArrayList);
        weatherListView.setAdapter(weatherAdapter);

    }
}