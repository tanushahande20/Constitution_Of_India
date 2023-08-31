package com.example.constitution_of_india.Fragmets;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.constitution_of_india.R;
import com.example.constitution_of_india.Roomdb.InsertActivity;

public class NotesActivity extends AppCompatActivity {
    ImageView add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NotesActivity.this,InsertActivity.class);
                startActivity(in);
            }
        });
    }
}