package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    public void delete(View view)
    {
        db.deleteAll();
    }


    public void back(View view)
    {
        //to get back to home page
        Intent page = new Intent(this, MainActivity.class);
        startActivity(page);
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
