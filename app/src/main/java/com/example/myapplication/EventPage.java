package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class EventPage extends AppCompatActivity {

    public static LinkedList<Event> events = Interface.events;
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        db = new DatabaseManager(this);


        Spinner hours = (Spinner) findViewById(R.id.eventTimeH);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hoursArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hours.setAdapter(adapter);

        Spinner minutes = (Spinner) findViewById(R.id.eventTimeM);
        adapter = ArrayAdapter.createFromResource(this, R.array.minutesArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minutes.setAdapter(adapter);

        Spinner day = (Spinner) findViewById(R.id.eventDay);
        adapter = ArrayAdapter.createFromResource(this, R.array.dayArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter);

        Spinner month = (Spinner) findViewById(R.id.eventMonth);
        adapter = ArrayAdapter.createFromResource(this, R.array.monthArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month.setAdapter(adapter);

        Spinner year = (Spinner) findViewById(R.id.eventYear);
        adapter = ArrayAdapter.createFromResource(this, R.array.yearArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(adapter);
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
        Spinner timeH = findViewById(R.id.eventTimeH);
        Spinner timeM = findViewById(R.id.eventTimeM);
        Spinner month = findViewById(R.id.eventMonth);
        Spinner day = findViewById(R.id.eventDay);
        Spinner year = findViewById(R.id.eventYear);
        TextView n = (TextView)findViewById(R.id.eventName);

        try{
            String name = event.getText().toString();
            if(name.equals("")){
                Toast.makeText(this, "Please name your event", Toast.LENGTH_SHORT).show();
            }
            String date = month.getSelectedItem().toString()+"/"+day.getSelectedItem().toString()+"/"+year.getSelectedItem().toString();
            if(day.equals("")){
                Toast.makeText(this, "Please enter a date", Toast.LENGTH_SHORT).show();
            }
            String time = timeH.getSelectedItem().toString()+":"+timeM.getSelectedItem().toString();
            if(time.equals("")){
                Toast.makeText(this, "Please enter the time", Toast.LENGTH_SHORT).show();
            }
            Manager m = new Manager(name, date, time);
            db.insert(m);

            n.setText("");
        }
        catch (Exception e){
            Toast.makeText(this, "Problem with input", Toast.LENGTH_SHORT).show();
        }
    }
}
