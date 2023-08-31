package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.constitution_of_india.Fragmets.AboutActivity;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.Preamble;
import com.example.constitution_of_india.R;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PreambleActivity extends AppCompatActivity {

    TextView text1 , text3 , text5;
    ImageView img2 ,cback;

    ProgressBar progressBar;
    String title = "" ;
    String description = "" ;
    String image = "" ;
    private ShareActionProvider mShareActionProvider;





    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preamble);
        cback=findViewById(R.id.prback);

        text1 = findViewById(R.id.text1);
        text3 = findViewById(R.id.text3);
        text5 = findViewById(R.id.text5);
        progressBar=findViewById(R.id.progressbar);
        img2 = findViewById(R.id.img2);
        getData();
        cback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreambleActivity.this, Home_Page.class);
                startActivity(intent);
            }
        });




    }

    private void getData() {
        Call<List<Preamble>> call= Api_Client.getTrycatchInterface(PreambleActivity.this).getData();
        call.enqueue(new Callback<List<Preamble>>() {
            @Override
            public void onResponse(Call<List<Preamble>> call, Response<List<Preamble>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.code()==200 && response.body()!=null){
                    Toast.makeText(PreambleActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                text1.setText(response.body().get(0).getTitle());
                    text5.setText(response.body().get(0).getDescription());
                    Glide.with(PreambleActivity.this).load(response.body().get(0).getImage()).placeholder(R.drawable.flag_image).into(img2);
                }



            }

            @Override
            public void onFailure(Call<List<Preamble>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(PreambleActivity.this, "onFailure", Toast.LENGTH_SHORT).show();


            }
        });





    }
}