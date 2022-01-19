package com.example.mobilizeyourplc;


import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public String getStringTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return dateFormat.format(getTime());
    }
    public void setTime(Date time) {
        this.time = time;
    }

}