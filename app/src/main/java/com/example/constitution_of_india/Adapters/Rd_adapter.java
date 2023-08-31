package com.example.constitution_of_india.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.constitution_of_india.R;
import com.example.constitution_of_india.Roomdb.AdapterListener;
import com.example.constitution_of_india.Roomdb.PojoOne;

import java.util.ArrayList;
import java.util.List;

public class Rd_adapter extends RecyclerView.Adapter<Rd_adapter.ViewHolder> {
    Context context;
    AdapterListener listener ;
    List<PojoOne> arrayList;

    public Rd_adapter(Context context, AdapterListener listener) {
        this.context = context;
        this.listener = listener;
        arrayList = new ArrayList<>();
    }

    public void addUser(PojoOne pojo){
        arrayList.add(pojo);
        notifyDataSetChanged();
    }
    public void clearData( ){
        arrayList.clear();
        notifyDataSetChanged();
    }
    public void removeUser(int position)
    {
        arrayList.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Rd_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rd_singlerow,parent,false);
        return new Rd_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Rd_adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int newPos = position;

        if(arrayList.get(position).getName()!=null && arrayList.get(position).getTitle()!=null){
            holder.text29.setText(arrayList.get(position).getTitle().toString());
            holder.text30.setText(arrayList.get(position).getName().toString());

            holder.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnUpdate(arrayList.get(position));
                }
            });

            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnDelete(arrayList.get(position).getId(),position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text29 , text30;
        ImageView update , delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text29 = itemView.findViewById(R.id.text29);
            text30 = itemView.findViewById(R.id.text30);
            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
