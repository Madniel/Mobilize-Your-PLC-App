package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class capping {

    @SerializedName("deviceId")
    private int deviceId;

    public capping(int deviceId) {
        this.deviceId = deviceId;

    }

    public int getDeviceId() {
        return deviceId;
    }

}
