package com.cacttuseducation_21_22.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnLoginActivity, btnCalculator, btnFunFacts, btnListView,
    btnPersonList,btnWeather,btnCompany, btnPanda, btnRecyclerView, btnStaticFragment,
    btnDynamicFragment,btnMenuExample,btnHeroes, btnWebView, btnMultiLanguage,
            btnSharedPreferences, btnAnimations, btnInterstitialAd, btnRewardAd;

    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginActivity = findViewById(R.id.btnLoginActivity);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnFunFacts = findViewById(R.id.btnFunFacts);
        btnListView = findViewById(R.id.btnListView);
        btnPersonList = findViewById(R.id.btnPersonList);
        btnWeather = findViewById(R.id.btnWeather);
        btnCompany = findViewById(R.id.btnCompany);
        btnPanda = findViewById(R.id.btnPanda);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
        btnStaticFragment = findViewById(R.id.btnStaticFragment);
        btnDynamicFragment = findViewById(R.id.btnDynamicFragment);
        btnMenuExample = findViewById(R.id.btnMenuExample);
        btnHeroes = findViewById(R.id.btnHeroes);
        btnWebView = findViewById(R.id.btnWebView);
        btnMultiLanguage = findViewById(R.id.btnMultiLanguageActivity);
        btnSharedPreferences = findViewById(R.id.btnSharedPreferences);
        btnAnimations = findViewById(R.id.btnAnimations);
        adView = findViewById(R.id.adView);
        btnInterstitialAd = findViewById(R.id.btnInterstitialAd);
        btnRewardAd = findViewById(R.id.btnRewardAd);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        implementInterstitialAd();
        implementRewardedAd();

        btnInterstitialAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null){
                    mInterstitialAd.show(MainActivity.this);
                }else {
                    Toast.makeText(MainActivity.this, "Ad isn't loaded yet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRewardAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRewardedAd != null) {
                    Activity activityContext = MainActivity.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            // Handle the reward.
                            int rewardAmount = rewardItem.getAmount();
                            String rewardType = rewardItem.getType();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnAnimations.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AnimationsActivity.class);
            overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_bottom);
            startActivity(intent);
        });

        btnSharedPreferences.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
            startActivity(intent);
        });

        btnMultiLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MultiLanguageActivity.class);
            startActivity(intent);
        });

        btnWebView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            startActivity(intent);
        });

        btnHeroes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HeroesActivity.class);
            startActivity(intent);
        });


        btnLoginActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        btnCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
            startActivity(intent);
        });

        btnFunFacts.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FunFactsActivity.class);
            startActivity(intent);
        });

        btnListView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

        btnPersonList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonActivity.class);
            startActivity(intent);
        });
        btnWeather.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            startActivity(intent);
        });

        btnCompany.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CompanyActivity.class);
            startActivity(intent);
        });

        btnPanda.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PandaActivity.class);
            startActivity(intent);
        });

        btnRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerViewExampleActivity.class);
            startActivity(intent);
        });

        btnStaticFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StaticFragmentHolderActivity.class);
            startActivity(intent);
        });

        btnDynamicFragment.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DynamicFragmentHolderActivity.class);
            startActivity(intent);
        });

        btnMenuExample.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
            startActivity(intent);
        });

        System.out.println("metoda e thirrur eshte: onCreate");

        Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();

        if (getIntent().getExtras() != null){
            boolean value = getIntent().getBooleanExtra("booleanKey",false);
            String stringValue = getIntent().getStringExtra("stringKey");
            System.out.println("Vlera ne ardhje eshte: " + stringValue);
        }
    }

    private void implementRewardedAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                    }
                });
    }

    private void implementInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });

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

    @Override
    public void onBackPressed() {
      //  super.onBackPressed();
        //showAlertDialog();
        //showTimePickerDialog();
       // showProgressDialog();

        Intent intent = getIntent();
        intent.putExtra("key",100);
        setResult(RESULT_OK,intent);
        finish();
    }

    private void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("First Progress Dialog");
        progressDialog.setMessage("Loading");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Yes clicked", Toast.LENGTH_SHORT).show();
            }
        });
        progressDialog.show();

    }

    private void showTimePickerDialog() {
        final int hour, minute;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, "Ora qe keni zgjedhur eshte: " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("First Dialog");
        alertDialogBuilder.setMessage("Do you want to close the app?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}