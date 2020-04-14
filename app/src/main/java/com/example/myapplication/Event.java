package com.example.myapplication;

import android.graphics.Color;

public class Event
{
    //event object
    public String eventName, eventDate, eventTimeH, eventTimeM;
    public static int color = Color.parseColor("#000000");
    public static double alertTime;

    public Event(String event, String date, String timeh, String timem)
    {
        eventName = event;
        eventDate = date;
        eventTimeH = timeh;
        eventTimeM = timem;
    }
}
