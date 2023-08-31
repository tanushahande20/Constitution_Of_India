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

import com.example.constitution_of_india.Activity.SchedulesActivity;
import com.example.constitution_of_india.Pojos.Notification;
import com.example.constitution_of_india.R;

import java.util.ArrayList;
import java.util.List;

public class Notification_adapter extends RecyclerView.Adapter<Notification_adapter.Viewholder> {
    Context context;
    List<Notification> notifications = new ArrayList<>();

    public Notification_adapter(Context context, List<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public Notification_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_adapter,parent,false);
        return new Notification_adapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Notification_adapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.text_notification.setText(notifications.get(position).getSmallDescription());
        holder.text_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test = notifications.get(position).getId();
                Intent intent = new Intent(context, SchedulesActivity.class);
                intent.putExtra("id",notifications.get(position).getId());
                intent.putExtra("title",notifications.get(position).getTitle());
                intent.putExtra("desc",notifications.get(position).getSmallDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class
    Viewholder extends RecyclerView.ViewHolder {
        TextView text_notification;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            text_notification = itemView.findViewById(R.id.text_notification);
        }
    }
}
