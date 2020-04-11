package com.example.myapplication;

import androidx.annotation.NonNull;

public class Manager {
    private String website;
    private String password;

    public Manager(String web, String pass){
        website = web;
        password = pass;
    }

    public String getWebsite(){
        return website;
    }

    public String getPassword(){
        return password;
    }

    @NonNull
    public String toString(){
        return website + " " + password;
    }
}
