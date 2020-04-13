package com.example.myapplication;

import android.content.Context;
import android.widget.RelativeLayout;

import java.util.LinkedList;

public class Interface extends RelativeLayout
{
    public static LinkedList<Event> events;
    public static LinkedList<Integer> ids;

    //set interface for event lists here
    public Interface(Context context)
    {
        super(context);
        events=new LinkedList<>();
        ids = new LinkedList<>();
        final int dp = (int) (getResources().getDisplayMetrics().density);
    }
}
