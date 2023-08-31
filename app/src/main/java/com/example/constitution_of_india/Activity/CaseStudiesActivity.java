package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.constitution_of_india.R;

public class CaseStudiesActivity extends AppCompatActivity {
    TextView text16 , text17;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_studies);
        text16 = findViewById(R.id.text16);
        text17 = findViewById(R.id.text17);
        Intent intent = getIntent();
        text16.setText(intent.getStringExtra("title"));
        text17.setText(intent.getStringExtra("desc"));
    }
}