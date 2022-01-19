package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class chartValue {
    @SerializedName("dateTime")
    private Date dateTime;

    @SerializedName("value")
    private int value;

    public Date getDateTime() {
        return dateTime;
    }

    public String getStringTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return dateFormat.format(getDateTime());
    }


    public int getValue() {
        return value;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
