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

import com.example.constitution_of_india.Activity.CaseStudiesActivity;
import com.example.constitution_of_india.Pojos.CaseStudies;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class CaseStudies_adapter extends RecyclerView.Adapter<CaseStudies_adapter.Viewholder> {
    Context context;
    List<CaseStudies> caseStudies = new ArrayList<>();

    public CaseStudies_adapter(Context context, List<CaseStudies> caseStudies) {
        this.context = context;
        this.caseStudies = caseStudies;
    }

    @NonNull
    @Override
    public CaseStudies_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.casestudies_adapter,parent,false);
        return new CaseStudies_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaseStudies_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_case.setText(caseStudies.get(position).getTitle());
        holder.txt_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test = caseStudies.get(position).getId();
                Intent intent = new Intent(context, CaseStudiesActivity.class);
                intent.putExtra("id",caseStudies.get(position).getId());
                intent.putExtra("title",caseStudies.get(position).getTitle());
                intent.putExtra("desc",caseStudies.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return caseStudies.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_case;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txt_case = itemView.findViewById(R.id.txt_case);
        }
    }
}
