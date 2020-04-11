package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

public class DatabaseManager extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "EVENTS_DB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "EVENTS_DB";
    private LinkedList<Integer> ids;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String command = "CREATE TABLE " + TABLE_NAME + "(" +
                "EVENT event, " +
                "DATE date," +
                "TIME time)";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Manager m){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("EVENT", m.getEvent());
        row.put("DATE", m.getDate());
        row.put("TIME", m.getTime());
        db.insert(TABLE_NAME, null, row);
        db.close();
    }

    public void delete(String site){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "EVENT = ?", new String[]{site});
        db.close();
    }

    public void update(String event, String date, String time){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put("EVENT", event);
        row.put("DATE", date);
        row.put("TIME", time);
        db.update(TABLE_NAME, row, "EVENT = ?", new String[]{event});
        db.close();
    }

    public LinkedList<Manager> select(String site){
        SQLiteDatabase db = getWritableDatabase();

        LinkedList<Manager> list = new LinkedList<Manager>();

        Cursor cursor = db.query(TABLE_NAME, new String[]{"WEBSITE", "PASSWORD"},
                "WEBSITE = ?", new String[]{site},
                null, null, null);

        while(cursor.moveToNext()){
            String event = cursor.getString(0);
            String date = cursor.getString(1);
            String time = cursor.getString(2);
            Manager m = new Manager(event, date, time);
            list.addLast(m);
        }
        cursor.close();
        db.close();

        return list;
    }

    public LinkedList<Manager> all(){
        SQLiteDatabase db = getWritableDatabase();
        LinkedList<Manager> list = new LinkedList<Manager>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"TITLE", "DATE", "TIME"},
                null, null, null, null, null, null);
        while(cursor.moveToNext()){
            String title = cursor.getString(0);
            String date = cursor.getString(1);
            String time = cursor.getString(2);
            Manager m = new Manager(title, date, time);
            list.addLast(m);
        }
        cursor.close();
        db.close();

        return list;
    }
}
