package com.example.mobilizeyourplc;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Alarm {

    @SerializedName("description")
    private String name;
    @SerializedName("time")
    private Date time;

    public Alarm(String name, Date time) {
        this.name = name;
        this.time = time;
    }

    public Alarm(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

}