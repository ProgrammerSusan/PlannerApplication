package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.LinkedList;

public class EventPage extends AppCompatActivity {

    public static LinkedList<Event> events = Interface.events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
    }

    public class TextChangeHandler implements TextWatcher
    {
        //build textlistener
        public String name, description;
        public double time;
        public View view;

        public void TextChangedHandler(View v)
        {
            view=v;
        }

        //these two classes are here because they have to be
        public void beforeTextChanged(CharSequence c, int i, int j, int k){}
        public void onTextChanged(CharSequence c, int i, int j, int k){}

        //what we're really interested in; the stuff handler
        public void afterTextChanged(Editable e)
        {
            if (view==findViewById(R.id.eventName))
                name = e.toString();
            else if (view==findViewById(R.id.eventTime))
                time = Double.parseDouble(e.toString());
            else if (view==findViewById(R.id.eventDescription))
                description = e.toString();

            Event temp = new Event(time, name, description);
            if(!events.contains(temp))
                events.add(temp);
            else
            {
                Event temp2 = events.get(events.indexOf(temp));
                temp2.eventName = name;
                temp2.time = time;
                temp2.description = description;
            }
        }
    }

    public void back(View view)
    {
        if (view.getId() == findViewById(R.id.back).getId())
        {
            Intent page = new Intent(this, MainActivity.class);
            startActivity(page);
        }
    }
}
