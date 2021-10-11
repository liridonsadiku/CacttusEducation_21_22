package com.cacttuseducation_21_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("metoda e thirrur eshte: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("metoda e thirrur eshte: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("metoda e thirrur eshte: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("metoda e thirrur eshte: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("metoda e thirrur eshte: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("metoda e thirrur eshte: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("metoda e thirrur eshte: onDestroy");

    }
}