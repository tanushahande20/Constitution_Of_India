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

import com.example.constitution_of_india.Pojos.Schedule;
import com.example.constitution_of_india.R;
import com.example.constitution_of_india.Activity.SchedulesActivity;

import java.util.ArrayList;
import java.util.List;

public class Schedule_adapter extends RecyclerView.Adapter<Schedule_adapter.Viewholder> {
    Context context;
    List<Schedule> schedules = new ArrayList<>();

    public Schedule_adapter(Context context, List<Schedule> schedules) {
        this.context = context;
        this.schedules = schedules;
    }

    @NonNull
    @Override
    public Schedule_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedules_adapter,parent,false);
        return new Schedule_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Schedule_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_schedule.setText(schedules.get(position).getTitle());
        holder.txt_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test = schedules.get(position).getId();
                Intent intent = new Intent(context, SchedulesActivity.class);
                intent.putExtra("id",schedules.get(position).getId());
                intent.putExtra("title",schedules.get(position).getTitle());
                intent.putExtra("desc",schedules.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txt_schedule;
        public Viewholder(View view) {
            super(view);
            txt_schedule = itemView.findViewById(R.id.txt_schedule);
        }
    }
}
