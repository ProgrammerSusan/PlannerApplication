package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActionBar;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import static com.example.myapplication.Interface.events;


public class MainActivity extends AppCompatActivity
{
    Interface anInterface;
    private DatabaseManager db;
    Context context;
    int color = Event.color;
    private String currentDate;
    private OptionsDatabase options;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        anInterface = new Interface(this);
        setContentView(R.layout.activity_main);
        db = new DatabaseManager(this);
        TableLayout upcomingEvents =(TableLayout)findViewById(R.id.events);
        showAllEvents(upcomingEvents);
        context=this;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat minute = new SimpleDateFormat("mm");
        options = new OptionsDatabase(this);
        Date date = new Date();
        currentDate = dateFormat.format(date);
        String min = (String)minute.format(date);
        LinkedList<Manager> events = db.all();
        LinkedList<Manager> currentEvents = new LinkedList<>();
        for(int i = 0; i < events.size(); i++){
            if(events.get(i).getDate().equals(currentDate)){
                currentEvents.addLast(events.get(i));
            }
        }
        if(currentEvents.size() > 0 && min.equals(options.getTime())){
            alert(currentEvents);
        }
    }

    public void alert(LinkedList<Manager> events)
    {
        //alert box needs to be called with the event that's triggering it passed in order to display properly
        //alert box
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

        for(int i = 0; i < events.size(); i++){
            alert.setMessage(events.get(i).getEvent());
        }

        alert.setPositiveButton("Clear today's events",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                db.deleteAllPast(currentDate);
            }
        });

        alert.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertbox = alert.create();
        alertbox.setIcon(android.R.drawable.ic_dialog_alert);
        alertbox.setCancelable(true);

        alertbox.show();
        alertbox.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color);
        alertbox.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(color);

    }

    public void showAllEvents(TableLayout plans){
        int dp = (int)(getResources().getDisplayMetrics().density);
        LinkedList<Manager> events = db.all();
        for(int i = 0; i < events.size(); i++){
            TableRow tr1 = new TableRow(this);
            tr1.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
            TextView event = new TextView(this);
            event.setText(events.get(i).getEvent()+"   ");
            TextView date = new TextView(this);
            date.setText(events.get(i).getDate()+"   ");
            TextView time = new TextView(this);
            time.setText(events.get(i).getTime()+"   ");
            event.setTextSize(10*dp);
            date.setTextSize(10*dp);
            time.setTextSize(10*dp);
            event.setTextColor(color);
            date.setTextColor(color);
            time.setTextColor(color);
            tr1.addView(event);
            tr1.addView(date);
            tr1.addView(time);
            plans.addView(tr1);
        }
    }

    public void options(View view)
    {
        //goes to options page
        if (view.getId() == findViewById(R.id.opt).getId())
        {
            Intent page = new Intent(this, Options.class);
            startActivity(page);
        }
    }


    //add event button is for adding events
    //user should be able to click on individual events to get the eventPage.java with the preexisting info filled in
    public void editEvent(View view)
    {
        //add button takes user to a blank eventsPage.java so they can fill all of the info in
        if (view.getId() == findViewById(R.id.add).getId())
        {
            Intent page = new Intent(this, EventPage.class);
            startActivity(page);
        }
    }
}