package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.cacttuseducation_21_22.R;
import com.squareup.picasso.Picasso;

public class PandaActivity extends AppCompatActivity {

    ImageView ivPanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panda);

        ivPanda = findViewById(R.id.ivPanda);

        Picasso.get().load("https://i.imgur.com/DvpvklR.png")
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.panda)
                .into(ivPanda);
    }
}