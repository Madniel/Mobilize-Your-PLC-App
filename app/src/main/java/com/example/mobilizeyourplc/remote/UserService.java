package com.example.mobilizeyourplc.remote;

import com.example.mobilizeyourplc.Alarm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/Device/SendMessage")
    Call<Void> message(@Body message message);

    @POST("api/User/Login")
    Call<Void> login(@Body login login);

    @POST("api/User/SetParameters")
    Call<Void> setParameters(ArrayList<parameter> parameter);

    @GET("api/Device/GetDevices")
    Call<ArrayList<device>> getDevices();

    @GET("api/Device/GetStatus")
    Call<status> status(@Body standardRequest request);

    @GET("api/Device/GetAlarms")
    Call<ArrayList<Alarm>> alarms(@Body standardRequest request);

    @GET("api/Device/GetParameters")
    Call<ArrayList<parameter>> parameters(@Body standardRequest request);

    @GET("api/Device/GetPicksCompleted")
    Call<chartValue> picks(@Body standardRequest request);

    @GET("api/Device/GetDispenseTime")
    Call<chartValue> dispense(@Body standardRequest request);

    @GET("api/Device/GetFillTime")
    Call<chartValue> fill(@Body standardRequest request);

    @GET("api/Device/GetCappingTime")
    Call<chartValue> capping(@Body standardRequest request);

}