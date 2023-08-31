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

import com.example.constitution_of_india.Adapters.Schedule_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.Schedule;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Schedule_Api_calling extends AppCompatActivity {
    ImageView cbackkk ;
    RecyclerView recyclerView;
    ProgressBar progressBar3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_api_calling);
        recyclerView =  findViewById(R.id.recycle2);
        progressBar3 = findViewById(R.id.progressbar3);
        cbackkk = findViewById(R.id.cbackkk);
        getnames();
        cbackkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Schedule_Api_calling.this,Home_Page.class);
                startActivity(intent);
            }
        });
    }

    private void getnames() {
        Call<List<Schedule>> call = Api_Client.getTrycatchInterface(Schedule_Api_calling.this).getScheduleData();
        call.enqueue(new Callback<List<Schedule>>() {
            @Override
            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
                if (response.code()==200 && response.body()!=null){
                    progressBar3.setVisibility(View.GONE);
                    Schedule_adapter schedule_adapter = new Schedule_adapter(Schedule_Api_calling.this,response.body());
                    recyclerView.setLayoutManager(new LinearLayoutManager(Schedule_Api_calling.this));
                    recyclerView.setAdapter(schedule_adapter);
                    Toast.makeText(Schedule_Api_calling.this, "successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Schedule_Api_calling.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Schedule>> call, Throwable t) {
                progressBar3.setVisibility(View.GONE);
                Toast.makeText(Schedule_Api_calling.this, "On Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}