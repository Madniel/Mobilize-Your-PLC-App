package com.example.mobilizeyourplc.remote;

import com.example.mobilizeyourplc.Alarm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("api/Device/SendMessage")
    Call<Void> message(@Body message message);

    @POST("api/User/Login")
    Call<Void> login(@Body login login);

    @POST("api/User/SetParameters")
    Call<Void> setParameters(@Body ArrayList<parameter> parameter);

    @GET("api/Device/GetDevices")
    Call<ArrayList<device>> getDevices();

    @GET("api/Device/GetStatus")
    Call<ArrayList<status>> status(@Query("deviceId") int deviceId);

    @GET("api/Device/GetAlarms")
    Call<ArrayList<Alarm>> alarms(@Query("deviceId") int deviceId);

    @GET("api/Device/GetParameters")
    Call<ArrayList<parameter>> parameters(@Query("deviceId") int deviceId);

    @GET("api/Device/GetPicksCompleted")
    Call<ArrayList<chartValue>> picks(@Query("deviceId") int deviceId);

    @GET("api/Device/GetDispenseTime")
    Call<ArrayList<chartValue>> dispense(@Query("deviceId") int deviceId);

    @GET("api/Device/GetFillTime")
    Call<ArrayList<chartValue>> fill(@Query("deviceId") int deviceId);

    @GET("api/Device/GetCappingTime")
    Call<ArrayList<chartValue>> capping(@Query("deviceId") int deviceId);

}