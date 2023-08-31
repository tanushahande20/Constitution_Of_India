package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.constitution_of_india.R;

public class SchedulesActivity extends AppCompatActivity {
    TextView text10 , text12;
    ImageView cbackk;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);
        text10 = findViewById(R.id.text10);
        text12 = findViewById(R.id.text12);
        cbackk = findViewById(R.id.cbackk);
        Intent intent = getIntent();
        text10.setText(intent.getStringExtra("title"));
        text12.setText(intent.getStringExtra("desc"));
        cbackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SchedulesActivity.this, Schedule_Api_calling.class);
                startActivity(intent);
            }
        });

        VideoView videoView = (VideoView) findViewById(R.id.img6);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/" +R.raw.video2));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();

    }
}