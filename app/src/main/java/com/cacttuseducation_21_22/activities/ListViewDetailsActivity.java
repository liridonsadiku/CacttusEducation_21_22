package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;

public class ListViewDetailsActivity extends AppCompatActivity {


    TextView tvCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_details);
        tvCountry = findViewById(R.id.tvCountry);
        if (getIntent().getStringExtra("countryKey") != null) {
            String country = getIntent().getStringExtra("countryKey");
            tvCountry.setText(country);
        }

    }
}