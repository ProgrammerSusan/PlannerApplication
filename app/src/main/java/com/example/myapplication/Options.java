package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Options extends AppCompatActivity
{
    public RadioButton red, orange, yellow, green, blue, indego, violet;
    public RadioButton halfHour, hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void timeOnClick(View view)
    {
        //to get the amount of time the user wants to be notified before an event
        halfHour = (RadioButton) view;
        hour = (RadioButton) view;

        if(halfHour.isChecked())
            Event.alertTime = .5;
        else
            Event.alertTime = 1;
    }

    public void colorOnClick(View view)
    {
        //to change the color of the event list text
        red = findViewById(R.id.red);
        orange = findViewById(R.id.orange);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        indego = findViewById(R.id.indego);
        violet = findViewById(R.id.violet);

        if      (red.isChecked())
            Event.color = Color.parseColor("#AE4040");
        else if (orange.isChecked())
            Event.color = Color.parseColor("#BD7E00");
        else if (yellow.isChecked())
            Event.color = Color.parseColor("#C1BF22");
        else if (green.isChecked())
            Event.color = Color.parseColor("#157126");
        else if (blue.isChecked())
            Event.color = Color.parseColor("#155B71");
        else if (indego.isChecked())
            Event.color = Color.parseColor("#271571");
        else if (violet.isChecked())
            Event.color = Color.parseColor("#3A0D56");
    }

    public void back(View view)
    {
        //to get back to the homepage
        if (view.getId() == findViewById(R.id.back).getId())
        {
            Intent page = new Intent(this, MainActivity.class);
            startActivity(page);
        }
    }
}
