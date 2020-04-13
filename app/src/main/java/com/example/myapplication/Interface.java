package com.example.myapplication;

import android.content.Context;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.LinkedList;

public class Interface extends RelativeLayout
{
    public static LinkedList<Event> events;
    public static LinkedList<Integer> ids;
    //public static Context context;
    public static RelativeLayout.LayoutParams params;

    //set interface for event lists here
    public Interface(Context context)
    {
        super(context);
        events=new LinkedList<>();
        ids = new LinkedList<>();
        final int dp = (int) (getResources().getDisplayMetrics().density);

//        for(int i = 0; i<events.size(); i++)
//        {
//            Button temp = new Button(context);
//            Integer index = new Integer(i);
//            temp.setText(events.get(i).time+" "+events.get(i).eventName);
//            temp.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18*dp);
//            temp.setId(Button.generateViewId());
//            index = temp.getId();
//            temp.setTextColor(Event.color);
//            temp.setPadding(15*dp, 15*dp, 15*dp, 15*dp);
//            params = new LayoutParams(params);
//            params.width = RelativeLayout.LayoutParams.MATCH_PARENT;
//            params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
//            temp.setLayoutParams(params);
//            addView(temp);
//        }
    }
}
