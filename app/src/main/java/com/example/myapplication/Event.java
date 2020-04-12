package com.example.myapplication;

public class Event
{
    public double time;
    public String eventName;
    public String description;
    public static int color;
    public static double alertTime;

    public Event(double Time, String event, String desc)
    {
        time = Time;
        eventName = event;
        description = desc;
    }
}
