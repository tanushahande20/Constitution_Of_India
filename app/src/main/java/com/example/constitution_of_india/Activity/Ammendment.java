package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.constitution_of_india.R;

import okhttp3.Response;

public class Ammendment extends AppCompatActivity {
    ImageView abackk;
    TextView text6 , text7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ammendment);
        text6 = findViewById(R.id.text6);
        text7 = findViewById(R.id.text7);
        abackk = findViewById(R.id.abackk);
        Intent intent = getIntent();
        text6.setText(intent.getStringExtra("title"));
        text7.setText(intent.getStringExtra("desc"));
        VideoView videoView = (VideoView) findViewById(R.id.img4);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/" +R.raw.video));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
        abackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ammendment.this,Amenment_api_calling.class);
                startActivity(intent);
            }
        });






    }
}