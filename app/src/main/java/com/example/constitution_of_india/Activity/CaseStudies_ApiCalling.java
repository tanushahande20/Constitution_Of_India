package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.constitution_of_india.Adapters.CaseStudies_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.CaseStudies;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CaseStudies_ApiCalling extends AppCompatActivity {
    RecyclerView recycle4;
    ProgressBar progressBar5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_studies_api_calling);
        recycle4 = findViewById(R.id.recycle4);
        progressBar5 = findViewById(R.id.progressbar5);
        getnames();

    }

    private void getnames() {
        Call<List<CaseStudies>> call = Api_Client.getTrycatchInterface(CaseStudies_ApiCalling.this).getCaseData();
        call.enqueue(new Callback<List<CaseStudies>>() {
            @Override
            public void onResponse(Call<List<CaseStudies>> call, Response<List<CaseStudies>> response) {
                if (response.code() ==200 && response.body()!=null){
                    progressBar5.setVisibility(View.GONE);
                    CaseStudies_adapter caseStudies_adapter = new CaseStudies_adapter(CaseStudies_ApiCalling.this,response.body());
                    recycle4.setLayoutManager(new LinearLayoutManager(CaseStudies_ApiCalling.this));
                    recycle4.setAdapter(caseStudies_adapter);
                }
                else {
                    Toast.makeText(CaseStudies_ApiCalling.this, "error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CaseStudies>> call, Throwable t) {
                Toast.makeText(CaseStudies_ApiCalling.this, "On Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}