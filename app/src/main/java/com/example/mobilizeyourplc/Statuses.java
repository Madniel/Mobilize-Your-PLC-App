package com.example.mobilizeyourplc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.status;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Statuses extends AppCompatActivity {

    UserService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statuses);
        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            try
            {
                LoadData();
            }
            catch (Exception e)
            {
                Toast.makeText(Statuses.this,"Failed to retrieve statuses from the server.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(Statuses.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadData() {
        api.status(MainActivity2.selectedDevice.getId()).enqueue(new Callback<ArrayList<status>>() {
            @Override
            public void onResponse(Call<ArrayList<status>> call, Response<ArrayList<status>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<status> list = response.body();
                    //TODO wyświetlić listę statusów
                }
                else
                {
                    Toast.makeText(Statuses.this,"Failed to retrieve statuses from the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<status>> call, Throwable t) {
                Toast.makeText(Statuses.this,"Failed to retrieve statuses from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}