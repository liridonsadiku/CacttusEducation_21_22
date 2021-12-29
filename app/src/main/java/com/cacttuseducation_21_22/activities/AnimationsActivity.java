package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;

public class AnimationsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnBounce, btnFadeInOut, btnMove;
    ImageView ivCacttus;
    Animation animationBounce, animationFadeInOut, animationMove;
    Spinner spinner;

    String[] students = {"Viktor", "Gjin", "Ensar", "Dion", "En"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        btnBounce = findViewById(R.id.btnBounce);
        ivCacttus = findViewById(R.id.ivCacttus);
        btnFadeInOut = findViewById(R.id.btnFadeInOut);
        btnMove = findViewById(R.id.btnMove);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(AnimationsActivity.this,android.R.layout.simple_spinner_item, students);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        animationFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out);
        animationMove = AnimationUtils.loadAnimation(this, R.anim.move);

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCacttus.startAnimation(animationBounce);
            }
        });

        btnFadeInOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCacttus.startAnimation(animationFadeInOut);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivCacttus.startAnimation(animationMove);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(AnimationsActivity.this, "Keni zgjedhur " + students[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}