package com.example.constitution_of_india.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.constitution_of_india.Partclick;
import com.example.constitution_of_india.Pojos.Parts;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class Parts_adapter extends RecyclerView.Adapter<Parts_adapter.Viewholder> {
    Context context;
    List<Parts> parts = new ArrayList<>();
    Partclick partclick;

    public Parts_adapter(Context context, List<Parts> parts,Partclick partclick) {
        this.context = context;
        this.parts = parts;
        this.partclick = partclick;
    }
    @NonNull
    @Override
    public Parts_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parts_adapter,parent,false);
        return new Parts_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Parts_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_parts.setText(parts.get(position).getTitle());
        holder.txt_parts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String test = parts.get(position).getTitle();
                Intent intent = new Intent(context, Parts_apicalling.class);
                intent.putExtra("id",parts.get(position).getId());
                intent.putExtra("title",parts.get(position).getTitle());
                intent.putExtra("desc",parts.get(position).getSmallDescription());
                context.startActivity(intent);*/
                partclick.OnClick(Integer.parseInt(parts.get(position).getId()));

            }
        });


    }

    @Override
    public int getItemCount() {
        return parts.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_parts;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txt_parts = itemView.findViewById(R.id.txt_parts);

        }
    }
}
