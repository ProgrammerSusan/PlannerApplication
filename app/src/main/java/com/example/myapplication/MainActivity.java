package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    Interface anInterface;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        anInterface = new Interface(this);
        setContentView(R.layout.activity_main);
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
