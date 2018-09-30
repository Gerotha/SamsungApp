package com.insightvalley.samsungapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class taskAdapter extends ArrayAdapter<Task>{

    private ArrayList<Task> tasks;
    private Context context;

    public taskAdapter(Context c, ArrayList<Task> objects) {
        super(c, 0, objects);
        this.tasks = objects;
        this.context = c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(tasks != null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.custom_task, parent, false);

            TextView taskTime = view.findViewById(R.id.taskTime);
            TextView taskDate = view.findViewById(R.id.taskDate);
            TextView taskTitle = view.findViewById(R.id.taskTitle);
            TextView taskDescription = view.findViewById(R.id.taskDescription);

            Task task = tasks.get(position);

            taskTime.setText(task.getHour());
            taskDate.setText(task.getDate());
            taskTitle.setText(task.getTitle());
            taskDescription.setText(task.getDescription());
        }


        return view;
    }
}
