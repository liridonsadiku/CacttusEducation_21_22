package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.cacttuseducation_21_22.R;

import java.util.Locale;

public class MultiLanguageActivity extends AppCompatActivity {

    Locale myLocale;
    Button btnEnglishLanguage, btnAlbanianLanguage, btnGermanLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_lanuage);
        btnEnglishLanguage = findViewById(R.id.btnEnglishLanguage);
        btnAlbanianLanguage = findViewById(R.id.btnAlbanianLanguage);
        btnGermanLanguage = findViewById(R.id.btnGermanLanguage);

        btnAlbanianLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("");
            }
        });

        btnEnglishLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });

        btnGermanLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("de");
            }
        });
    }

    private void setLocale(String language){
        myLocale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = myLocale;
        resources.updateConfiguration(configuration, displayMetrics);

        //refresh activity
        Intent intent = new Intent(this,MultiLanguageActivity.class);
        startActivity(intent);
        finish();
    }
}