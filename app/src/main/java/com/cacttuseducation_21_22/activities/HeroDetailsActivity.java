package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Hero;
import com.squareup.picasso.Picasso;

public class HeroDetailsActivity extends AppCompatActivity {

    ImageView ivHero;
    TextView tvPublisher, tvBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heero_details);
        ivHero = findViewById(R.id.ivHero);
        tvPublisher = findViewById(R.id.tvPublisher);
        tvBio = findViewById(R.id.tvBio);

        Hero hero = (Hero) getIntent().getSerializableExtra("heroObject");

        String imageUrl = hero.getImageurl();
        Picasso.get().load(imageUrl).placeholder(R.mipmap.ic_launcher).into(ivHero);

        tvPublisher.setText(hero.getPublisher());
        tvBio.setText(hero.getBio());

    }
}