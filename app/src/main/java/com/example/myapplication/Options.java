package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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
        halfHour = (RadioButton) view;
        hour = (RadioButton) view;

        if(halfHour.isChecked())
            Event.alertTime = .5;
        else
            Event.alertTime = 1;
    }

    public void colorOnClick(View view)
    {
        red = (RadioButton) view;
        orange = (RadioButton) view;
        yellow = (RadioButton) view;
        green = (RadioButton) view;
        blue = (RadioButton) view;
        indego = (RadioButton) view;
        violet = (RadioButton) view;

        if(red.isChecked())
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
        else
            Event.color = Color.parseColor("#3A0D56");
    }
}
