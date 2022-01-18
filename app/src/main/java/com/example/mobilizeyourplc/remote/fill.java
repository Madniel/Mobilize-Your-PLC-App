package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class fill {

    @SerializedName("deviceId")
    private int deviceId;

    public fill(int deviceId) {
        this.deviceId = deviceId;

    }

    public int getDeviceId() {
        return deviceId;
    }

}