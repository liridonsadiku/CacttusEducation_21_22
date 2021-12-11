package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.fragments.FirstFragment;
import com.cacttuseducation_21_22.fragments.SecondFragment;

public class DynamicFragmentHolderActivity extends AppCompatActivity {

    TextView tvFirstFragment, tvSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment_holder);
        tvFirstFragment = findViewById(R.id.tvFirstFragment);
        tvSecondFragment = findViewById(R.id.tvSecondFragment);

        loadFragment(new FirstFragment());

        tvFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FirstFragment());
            }
        });

        tvSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SecondFragment());
            }
        });
    }


    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();

        //fragment transaction for add, replace, remove fragments
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.relFragmentHolder, fragment);
        //save the changes
        fragmentTransaction.commit();

    }
}