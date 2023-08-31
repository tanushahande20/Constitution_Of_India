package com.example.constitution_of_india.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.constitution_of_india.Activity.NewsArticleActivity;
import com.example.constitution_of_india.Pojos.NewsArticle;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class NewsArticles_adapter extends RecyclerView.Adapter<NewsArticles_adapter.Viewholder> {
    Context context;
        List<NewsArticle> newsArticles = new ArrayList<>();

    public NewsArticles_adapter(Context context, List<NewsArticle> newsArticles) {
        this.context = context;
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public NewsArticles_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.newsarticles_adapter,parent,false);
        return new NewsArticles_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticles_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_news.setText(newsArticles.get(position).getTitle());
        holder.txt_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test = newsArticles.get(position).getId();
                Intent intent = new Intent(context, NewsArticleActivity.class);
                intent.putExtra("id",newsArticles.get(position).getId());
                intent.putExtra("title",newsArticles.get(position).getTitle());
                intent.putExtra("date",newsArticles.get(position).getDate());
                intent.putExtra("desc",newsArticles.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_news;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txt_news = itemView.findViewById(R.id.txt_news);
        }
    }
}
