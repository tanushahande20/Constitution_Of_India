package com.example.constitution_of_india.Fragmets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.constitution_of_india.Activity.Home_Page;
import com.example.constitution_of_india.R;

public class AboutActivity extends AppCompatActivity {
    ImageView dback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        dback=findViewById(R.id.dback);
        dback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, Home_Page.class);
                startActivity(intent);
            }
        });

    }

}