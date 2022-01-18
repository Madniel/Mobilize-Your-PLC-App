package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class chartValue {
    @SerializedName("dateTime")
    private Date dateTime;

    @SerializedName("value")
    private int value;

    public Date getDateTime() {
        return dateTime;
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
