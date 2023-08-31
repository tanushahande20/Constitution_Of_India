package com.example.constitution_of_india.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.constitution_of_india.Adapters.NewsArticles_adapter;
import com.example.constitution_of_india.Model.Api_Client;
import com.example.constitution_of_india.Pojos.NewsArticle;
import com.example.constitution_of_india.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsArticles_ApiCalling extends AppCompatActivity {
    RecyclerView recycle3;
    ProgressBar progressbar4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_articles_api_calling);
        recycle3 = findViewById(R.id.recycle3);
        progressbar4 = findViewById(R.id.progressbar4);
        getnames();
    }

    private void getnames() {
        Call<List<NewsArticle>> call = Api_Client.getTrycatchInterface(NewsArticles_ApiCalling.this).getNewsData();
        call.enqueue(new Callback<List<NewsArticle>>() {
            @Override
            public void onResponse(Call<List<NewsArticle>> call, Response<List<NewsArticle>> response) {
                if (response.code()==200 && response.body()!=null){
                    progressbar4.setVisibility(View.GONE);
                    NewsArticles_adapter newsArticles_adapter = new NewsArticles_adapter(NewsArticles_ApiCalling.this,response.body());
                    recycle3.setLayoutManager(new LinearLayoutManager(NewsArticles_ApiCalling.this));
                    recycle3.setAdapter(newsArticles_adapter);
                }
                else {
                    Toast.makeText(NewsArticles_ApiCalling.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<NewsArticle>> call, Throwable t) {
                progressbar4.setVisibility(View.GONE);
                Toast.makeText(NewsArticles_ApiCalling.this, "On failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}