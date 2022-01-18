package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class picks {

    @SerializedName("deviceId")
    private int deviceId;

    public picks(int deviceId) {
        this.deviceId = deviceId;

    }

    public int getDeviceId() {
        return deviceId;
    }

}
