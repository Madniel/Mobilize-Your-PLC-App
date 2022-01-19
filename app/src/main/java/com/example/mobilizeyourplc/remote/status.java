package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class status {
    @SerializedName("status")
    private String name;

    @SerializedName("value")
    private int value;

    public status(String name, int value) {
        this.name = name;
        this.value = value;

    }
    public status(){

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
