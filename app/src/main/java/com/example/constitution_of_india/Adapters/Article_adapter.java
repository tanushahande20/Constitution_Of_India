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

import com.example.constitution_of_india.Activity.Parts_Activity;
import com.example.constitution_of_india.Pojos.Article;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class Article_adapter extends RecyclerView.Adapter<Article_adapter.Viewholder> {
    Context context;
    List<Article> articles = new ArrayList<>();

    public Article_adapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public Article_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_adapter,parent,false);
        return new Article_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Article_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_article.setText(articles.get(position).getTitle());
        holder.text23.setText(articles.get(position).getSmallDescription());
        holder.txt_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test = articles.get(position).getId();
                Intent intent = new Intent(context, Parts_Activity.class);
                intent.putExtra("id",articles.get(position).getId());
                intent.putExtra("title",articles.get(position).getTitle());
                intent.putExtra("description",articles.get(position).getDescription());
                intent.putExtra("desc",articles.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_article , text23;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txt_article = itemView.findViewById(R.id.txt_article);
            text23 = itemView.findViewById(R.id.text23);
        }
    }
}
