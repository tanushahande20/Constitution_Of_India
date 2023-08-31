package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.Article;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parts_Activity extends AppCompatActivity {
    TextView text20 , text21 , text22;
    ProgressBar progressBar7;
    ImageView pbackk;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
        text20 = findViewById(R.id.text20);
        text21 = findViewById(R.id.text21);
        text22 = findViewById(R.id.text22);
        pbackk = findViewById(R.id.pbackk);
        progressBar7 = findViewById(R.id.progressbar7);
        getnames();
        pbackk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts_Activity.this, Parts_apicalling.class);
                startActivity(intent);
            }
        });

        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }

    private void getnames() {
        Call<List<Article>> call = Api_Client.getTrycatchInterface(Parts_Activity.this).getArticlesData();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.code()==200 && response.body()!=null) {
                    Toast.makeText(Parts_Activity.this, "Successful", Toast.LENGTH_SHORT).show();
                    text20.setText(response.body().get(0).getTitle());
                    text22.setText(response.body().get(0).getDescription());
                    text21.setText(response.body().get(0).getSmallDescription());
                    progressBar7.setVisibility(View.GONE);
                    VideoView videoView = (VideoView) findViewById(R.id.img5);
                    videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/" +R.raw.video));
                    MediaController mediaController = new MediaController(Parts_Activity.this);
                    videoView.setMediaController(mediaController);
                    videoView.start();
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Toast.makeText(Parts_Activity.this, "failure", Toast.LENGTH_SHORT).show();
                progressBar7.setVisibility(View.GONE);

            }
        });
    }
}