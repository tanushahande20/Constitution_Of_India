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

import com.example.constitution_of_india.Pojos.Ammendment;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class Amendment_adapter extends RecyclerView.Adapter<Amendment_adapter.Viewholder> {
    Context context;
    List<Ammendment> ammendments = new ArrayList<>();

    public Amendment_adapter(Context context, List<Ammendment> ammendments) {
        this.context = context;
        this.ammendments = ammendments;
    }

    @NonNull
    @Override
    public Amendment_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.ammendment_adapter,parent,false);
        return new Amendment_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Amendment_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {


        holder.txt_amendment.setText(ammendments.get(position).getTitle());
        holder.txt_amendment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test =ammendments.get(position).getId();
                Intent intent = new Intent(context , com.example.constitution_of_india.Activity.Ammendment.class);
                intent.putExtra("id",ammendments.get(position).getId());
                intent.putExtra("title",ammendments.get(position).getTitle());
                intent.putExtra("desc",ammendments.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ammendments.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_amendment ;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txt_amendment = itemView.findViewById(R.id.txt_amendment);


        }
    }
}
