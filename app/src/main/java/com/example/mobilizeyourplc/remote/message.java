package com.example.mobilizeyourplc.remote;
import com.google.gson.annotations.SerializedName;

public class message {
    @SerializedName("message")
    private String message;

    @SerializedName("deviceId")
    private int deviceId;

    public message(String title, int deviceId) {
        this.message = title;
        this.deviceId = deviceId;

    }

    public String getTitle() {
        return message;
    }

    public int getDeviceId() {
        return deviceId;
    }

}
