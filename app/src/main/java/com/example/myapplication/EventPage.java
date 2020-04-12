package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class EventPage extends AppCompatActivity {

    public static LinkedList<Event> events = Interface.events;
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        db = new DatabaseManager(this);
    }

    public class TextChangeHandler implements TextWatcher
    {
        //build textlistener
        public String name, date, time;
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
            else if (view==findViewById(R.id.eventDate))
                date = e.toString();
            else if (view==findViewById(R.id.eventTime))
                time = e.toString();

            Event temp = new Event(name, date, time);
            if(!events.contains(temp))
                events.add(temp);
            else
            {
                Event temp2 = events.get(events.indexOf(temp));
                temp2.eventName = name;
                temp2.eventDate = date;
                temp2.eventTime = time;
            }
        }
    }

    public void back(View view)
    {
        // Not necessary if there is already an onclick attached to the button

//        if (view.getId() == findViewById(R.id.back).getId())
//        {
            Intent page = new Intent(this, MainActivity.class);
            startActivity(page);
//        }
    }

    public void save(View view)
    {
        TextView event = (TextView)findViewById(R.id.eventName);
        TextView date = (TextView)findViewById(R.id.eventDate);
        TextView time = (TextView)findViewById(R.id.eventTime);

        try{
            String name = event.getText().toString();
            if(name.equals("")){
                Toast.makeText(this, "Please name your event", Toast.LENGTH_SHORT).show();
            }
            String day = date.getText().toString();
            if(day.equals("")){
                Toast.makeText(this, "Please enter a date", Toast.LENGTH_SHORT).show();
            }
            String hour = time.getText().toString();
            if(hour.equals("")){
                Toast.makeText(this, "Please enter the time", Toast.LENGTH_SHORT).show();
            }
            Manager m = new Manager(name, day, hour);
            db.insert(m);
        }
        catch (Exception e){
            Toast.makeText(this, "Problem with input", Toast.LENGTH_SHORT).show();
        }
    }
}
