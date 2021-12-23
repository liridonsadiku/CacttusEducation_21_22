package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.util.Prefs;

import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreferencesActivity extends AppCompatActivity {
    EditText etName, etEmail;
    Button btnSave, btnClear, btnRetrieve;

    String json = "{\"employee\":{\"name\":\"Cacttus Education\"}}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnSave = findViewById(R.id.btnSave);
        btnClear = findViewById(R.id.btnClear);
        btnRetrieve = findViewById(R.id.btnRetrieve);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject employeeObject = jsonObject.getJSONObject("employee");

            System.out.println("Name of employee " + employeeObject.getString("name") );

        }catch (JSONException e){
            e.printStackTrace();
        }


        btnSave.setOnClickListener(v -> {
            if (etName.getText().toString().length()>0 && etEmail.getText().toString().length()>0){
                Prefs.saveString(SharedPreferencesActivity.this,"name",etName.getText().toString());
                Prefs.saveString(SharedPreferencesActivity.this,"email",etEmail.getText().toString());

            }else {
                Toast.makeText(SharedPreferencesActivity.this, "Plese fill all the fields!", Toast.LENGTH_SHORT).show();
            }
        });

        btnClear.setOnClickListener(view ->{
            etEmail.setText("");
            etName.setText("");
        });

        btnRetrieve.setOnClickListener(view -> {
            String name = Prefs.getString(SharedPreferencesActivity.this,"name");
            etName.setText(name);

            String email = Prefs.getString(SharedPreferencesActivity.this, "email");
            etEmail.setText(email);
        });
    }
}