package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class OptionsDatabase extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "OPTIONS_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "OPTIONS_DB";

    public OptionsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String command = "CREATE TABLE " + TABLE_NAME + "(" +
                "PERIOD text)";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("PERIOD", "30");
        db.insert(TABLE_NAME, null, row);
        db.close();
    }

    public void update(String time){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("PERIOD", time);
        db.update(TABLE_NAME, row, null, null);
        db.close();
    }

    public String getTime(){
        String time = "";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"PERIOD"},
                null, null, null, null, null, null);
        while(cursor.moveToNext()){
            time = cursor.getString(0);
        }

        return time;
    }
}
