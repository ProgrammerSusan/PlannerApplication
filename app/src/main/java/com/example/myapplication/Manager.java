package com.example.myapplication;

import androidx.annotation.NonNull;

public class Manager {
    private String event;
    private String date;
    private String time;

    public Manager(String event, String date, String time){
        this.event = event;
        this.date = date;
        this.time = time;
    }

    public String getEvent(){
        return event;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }


    @NonNull
    public String toString(){
        return event + " on " + date + " at " + time;
    }
}
