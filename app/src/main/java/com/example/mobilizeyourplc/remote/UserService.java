package com.example.mobilizeyourplc.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/Device/SendMessage")
    Call<message> message(@Body message message);

    @FormUrlEncoded
    @POST("api/User/Login")
    Call<login> login(@Field("username") String username, @Field("password") String password);

}