package com.example.constitution_of_india.Fragmets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.constitution_of_india.Activity.NewsArticles_ApiCalling;
import com.example.constitution_of_india.Adapters.NewsArticles_adapter;
import com.example.constitution_of_india.Adapters.Notification_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.Notification;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progress;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        recyclerView=findViewById(R.id.recycle9);
        progress = findViewById(R.id.progress);
        getdata();
    }

    private void getdata() {
        Call<List<Notification>> call = Api_Client.getTrycatchInterface(NotificationsActivity.this).getNotificationsData();
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.code()==200 && response.body()!=null){
                    progress.setVisibility(View.GONE);
                    Notification_adapter notification_adapter = new Notification_adapter(NotificationsActivity.this,response.body());
                    recyclerView.setLayoutManager(new LinearLayoutManager(NotificationsActivity.this));
                    recyclerView.setAdapter(notification_adapter);
                }
                else {
                    Toast.makeText(NotificationsActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Toast.makeText(NotificationsActivity.this, "On failure", Toast.LENGTH_SHORT).show();


            }
        });
    }
}