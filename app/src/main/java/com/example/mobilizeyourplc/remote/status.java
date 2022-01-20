package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class status {
    @SerializedName("status")
    private String name;

    @SerializedName("value")
    private boolean value;

    public status(String name, boolean value) {
        this.name = name;
        this.value = value;

    }
    public status(){

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setValue(boolean value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }
}
