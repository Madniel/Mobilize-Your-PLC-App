package com.example.mobilizeyourplc.remote;

public class ApiUtils {

    public static final String BASE_URL = "http://146.59.17.234:5300/";

    public static UserService getApiClient(){
        return RetrofitClient.getClient(BASE_URL).getUserService();
    }
}