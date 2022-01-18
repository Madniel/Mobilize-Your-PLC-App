package com.example.mobilizeyourplc.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/Device/SendMessage")
    Call<message> message(@Body message message);

    @FormUrlEncoded
    @POST("api/User/Login")
    Call<login> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/User/SetParameters")
    Call<parameters> parameters(@Field("parameterName") String parameterName, @Field("deviceId") int deviceId, @Field("value") int value);

    @FormUrlEncoded
    @GET("api/Device/GetDevices")
    Call<device> device(@Field("name") String name, @Field("id") int id);

    @FormUrlEncoded
    @GET("api/Device/GetStatus")
    Call<status> status(@Field("name") String name, @Field("id") int id);

    @FormUrlEncoded
    @GET("api/Device/GetAlarms")
    Call<alarms> alarms(@Field("deviceId") int deviceId);

    @FormUrlEncoded
    @GET("api/Device/GetParameters")
    Call<parameters> parameters(@Field("deviceId") int deviceId);

    @FormUrlEncoded
    @GET("api/Device/GetPicksCompleted")
    Call<picks> picks(@Field("deviceId") int deviceId);

    @FormUrlEncoded
    @GET("api/Device/GetDispenseTime")
    Call<dispense> dispense(@Field("deviceId") int deviceId);

    @FormUrlEncoded
    @GET("api/Device/GetFillTime")
    Call<fill> fill(@Field("deviceId") int deviceId);

    @FormUrlEncoded
    @GET("api/Device/GetCappingTime")
    Call<capping> capping(@Field("deviceId") int deviceId);

}