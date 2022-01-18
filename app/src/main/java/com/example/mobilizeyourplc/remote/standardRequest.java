package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class standardRequest {

    @SerializedName("deviceId")
    private int deviceId;

    public standardRequest(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceId() {
        return deviceId;
    }
}
