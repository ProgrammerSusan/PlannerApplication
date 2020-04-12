package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity
{
    Interface anInterface;
    Event event;
    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        anInterface = new Interface(this);
        setContentView(R.layout.activity_main);
        db = new DatabaseManager(this);
        TableLayout upcomingEvents =(TableLayout)findViewById(R.id.events);
        showAllEvents(upcomingEvents);
    }

    public void showAllEvents(TableLayout plans){
        int dp = (int)(getResources().getDisplayMetrics().density);
        LinkedList<Manager> events = db.all();
        for(int i = 0; i < events.size(); i++){
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            TextView event = new TextView(this);
            event.setText(events.get(i).getEvent());
            TextView date = new TextView(this);
            date.setText(events.get(i).getDate());
            TextView time = new TextView(this);
            time.setText(events.get(i).getDate());
            event.setTextSize(10*dp);
            date.setTextSize(10*dp);
            tr1.addView(event);
            tr1.addView(date);
            tr1.addView(time);
            plans.addView(tr1);
        }
    }

    public void options(View view)
    {
        if (view.getId() == findViewById(R.id.opt).getId())
        {
            Intent page = new Intent(this, Options.class);
            startActivity(page);
        }
    }

    public void editEvent(View view)
    {
        if (view.getId() == findViewById(R.id.add).getId())
        {
            Intent page = new Intent(this, EventPage.class);
            startActivity(page);
        }
    }
}
