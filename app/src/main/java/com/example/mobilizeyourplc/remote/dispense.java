package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class dispense {

    @SerializedName("deviceId")
    private int deviceId;

    public dispense(int deviceId) {
        this.deviceId = deviceId;

    }

    public int getDeviceId() {
        return deviceId;
    }

}