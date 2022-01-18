package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class device {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public device(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
