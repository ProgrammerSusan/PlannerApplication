package com.example.myapplication;

public class Event
{
    public String eventName, eventDate, eventTime;
    public static int color;
    public static double alertTime;

    public Event(String event, String date, String time)
    {
        eventName = event;
        eventDate = date;
        eventTime = time;
    }
}
