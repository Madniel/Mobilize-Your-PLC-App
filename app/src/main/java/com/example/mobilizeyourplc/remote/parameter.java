package com.example.mobilizeyourplc.remote;

import com.google.gson.annotations.SerializedName;

public class parameter {
    @SerializedName("parameterName")
    private String parameterName;

    @SerializedName("deviceId")
    private int deviceId;

    @SerializedName("value")
    private int value;

    public parameter(String parameterName, int deviceId, int value) {
        this.parameterName = parameterName;
        this.deviceId = deviceId;
        this.value = value;

    }

    public String getParameter() {
        return parameterName;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public int getValue() {
        return value;
    }
}
