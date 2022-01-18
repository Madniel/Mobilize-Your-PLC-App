package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class alarms {
    @SerializedName("deviceId")
    private final int deviceId;

    public alarms(int deviceId) {
        this.deviceId = deviceId;

    }

    public int deviceId() {
        return deviceId;
    }
}
