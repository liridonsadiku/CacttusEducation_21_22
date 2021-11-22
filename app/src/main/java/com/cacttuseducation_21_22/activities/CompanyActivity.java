package com.cacttuseducation_21_22.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Company;

import java.util.ArrayList;

public class CompanyActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Company> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        gridView = findViewById(R.id.gridView);

        populateArrayList();

    }

    private void populateArrayList() {
        arrayList.add(new Company(R.mipmap.ic_launcher,"Samsung", "100k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Apple", "120k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Siemens", "90k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Dell", "120k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Google", "160k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Motorola", "140k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Huawei", "170k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Sony", "120k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Motorola", "160k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Huawei", "190k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Siemens", "130k"));
        arrayList.add(new Company(R.mipmap.ic_launcher,"Dell", "120k"));
    }
}