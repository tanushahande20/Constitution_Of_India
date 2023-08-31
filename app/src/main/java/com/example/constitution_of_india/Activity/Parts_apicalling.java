package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.constitution_of_india.Adapters.Article_adapter;
import com.example.constitution_of_india.Adapters.Parts_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Partclick;
import com.example.constitution_of_india.Pojos.Article;
import com.example.constitution_of_india.Pojos.Parts;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parts_apicalling extends AppCompatActivity implements Partclick {
    ImageView pback;
    RecyclerView recycle6 , recycle7;
    ProgressBar progressBar6;
    String part_Id = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts_apicalling);
        recycle6 = findViewById(R.id.recycle6);
        recycle7 = findViewById(R.id.recycle7);
        progressBar6 = findViewById(R.id.progressbar6);
        pback = findViewById(R.id.pback);
        pback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parts_apicalling.this,Home_Page.class);
                startActivity(intent);
            }
        });

        getnames();
       /* getData();*/

    }

    private void getData(int id) {
        Call<List<Article>> call= Api_Client.getTrycatchInterface(Parts_apicalling.this).getArticleData(id);
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                if (response.code() == 200 && response.body() != null){
                    Article_adapter article_adapter = new Article_adapter(Parts_apicalling.this,response.body());
                    recycle7.setLayoutManager(new LinearLayoutManager(Parts_apicalling.this ));
                    recycle7.setAdapter(article_adapter);

                }
                else {
                    Toast.makeText(Parts_apicalling.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Toast.makeText(Parts_apicalling.this, "On failure", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void getnames() {
        Call<List<Parts>> call= Api_Client.getTrycatchInterface(Parts_apicalling.this).getPartsData();
        call.enqueue(new Callback<List<Parts>>() {
            @Override
            public void onResponse(Call<List<Parts>> call, Response<List<Parts>> response) {
                if (response.code() == 200 && response.body() != null) {
                    progressBar6.setVisibility(View.GONE);
                    Parts_adapter parts_adapter = new Parts_adapter(Parts_apicalling.this, response.body(),Parts_apicalling.this);
                    recycle6.setLayoutManager(new LinearLayoutManager(Parts_apicalling.this, LinearLayoutManager.HORIZONTAL, true));
                    recycle6.setAdapter(parts_adapter);

                } else {
                    Toast.makeText(Parts_apicalling.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Parts>> call, Throwable t) {
                progressBar6.setVisibility(View.GONE);
                Toast.makeText(Parts_apicalling.this, "On failure", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void OnClick(int id) {
        getData(id);
    }
}