package com.insightvalley.samsungapp;

import android.text.Editable;

import com.google.firebase.database.FirebaseDatabase;

public class Task {

    String hour;
    String date;
    String title;
    String description;

    public Task() {
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setDescription(String description) {
        this.title = description;
    }

    public String getDescription() {
        return description;
    }
}

