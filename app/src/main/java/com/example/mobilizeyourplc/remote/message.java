package com.example.mobilizeyourplc.remote;
import com.google.gson.annotations.SerializedName;

public class message {
    @SerializedName("message")
    private String message;

    @SerializedName("deviceId")
    private int deviceId;

    public message(String message, int deviceId) {
        this.message = message;
        this.deviceId = deviceId;
    }

    public String getMessage() {
        return message;
    }

    public int getDeviceId() {
        return deviceId;
    }

}
