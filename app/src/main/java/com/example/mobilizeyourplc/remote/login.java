package com.example.mobilizeyourplc.remote;
import com.google.gson.annotations.SerializedName;

public class login {

    @SerializedName("email")
    private String username;

    @SerializedName("password")
    private String password;


    public login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
