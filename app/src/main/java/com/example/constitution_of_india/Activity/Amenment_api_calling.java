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

import com.example.constitution_of_india.Adapters.Amendment_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.Ammendment;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Amenment_api_calling extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressbar2;
    ImageView abackkk;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenment_api_calling);
        recyclerView = findViewById(R.id.recycle);
        progressbar2 = findViewById(R.id.progressbar2);
        abackkk = findViewById(R.id.abackkk);
        getnames();
        abackkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Amenment_api_calling.this,Home_Page.class);
                startActivity(intent);
            }
        });
    }
    private void getnames(){
        Call<List<Ammendment>> call = Api_Client.getTrycatchInterface(Amenment_api_calling.this).getAmendmentData();
        call.enqueue(new Callback<List<Ammendment>>() {
            @Override
            public void onResponse(Call<List<Ammendment>> call, Response<List<Ammendment>> response) {
                if (response.code() == 200 && response.body() != null) {
                    progressbar2.setVisibility(View.GONE);
                    Amendment_adapter amendment_adapter = new Amendment_adapter(Amenment_api_calling.this,response.body());
                    recyclerView.setLayoutManager(new LinearLayoutManager(Amenment_api_calling.this));
                    recyclerView.setAdapter(amendment_adapter);

                } else {
                    Toast.makeText(Amenment_api_calling.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Ammendment>> call, Throwable t) {
                progressbar2.setVisibility(View.GONE);
                Toast.makeText(Amenment_api_calling.this, "On Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}