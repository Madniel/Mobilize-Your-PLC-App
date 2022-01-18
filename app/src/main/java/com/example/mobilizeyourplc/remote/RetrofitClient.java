package com.example.mobilizeyourplc.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public final class RetrofitClient {
    private static RetrofitClient instance;

    private UserService userService;

    public static RetrofitClient getClient(String url) {
        if (instance == null) {
            instance = new RetrofitClient(url);
        }
        return instance;
    }

    public RetrofitClient(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    public UserService getUserService() {
        return userService;
    }
}