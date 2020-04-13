package com.example.myapplication;

import android.graphics.Color;

public class Event
{
    //event object
    public String eventName, eventDate, eventTime;
    public static int color = Color.parseColor("#000000");
    public static double alertTime;

    public Event(String event, String date, String time)
    {
        eventName = event;
        eventDate = date;
        eventTime = time;
    }
}
