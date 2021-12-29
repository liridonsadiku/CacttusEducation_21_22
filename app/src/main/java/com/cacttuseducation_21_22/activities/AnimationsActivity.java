package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.cacttuseducation_21_22.R;

public class AnimationsActivity extends AppCompatActivity {
    Button btnBounce;
    ImageView ivCacttus;
    Animation animationBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        btnBounce = findViewById(R.id.btnBounce);
        ivCacttus = findViewById(R.id.ivCacttus);

        animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCacttus.startAnimation(animationBounce);
            }
        });

    }
}