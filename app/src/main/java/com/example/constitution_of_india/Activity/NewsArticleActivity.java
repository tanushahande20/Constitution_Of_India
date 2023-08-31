package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.constitution_of_india.R;

public class NewsArticleActivity extends AppCompatActivity {
    TextView text13 , text14, text15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_article);
        text13 = findViewById(R.id.text13);
        text14 = findViewById(R.id.text14);
        text15 = findViewById(R.id.text15);
        Intent intent = getIntent();
        text13.setText(intent.getStringExtra("title"));
        text14.setText(intent.getStringExtra("date"));
        text15.setText(intent.getStringExtra("desc"));
    }
}