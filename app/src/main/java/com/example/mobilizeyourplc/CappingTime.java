package com.example.mobilizeyourplc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.chartValue;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CappingTime extends AppCompatActivity {

    UserService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capping_time);
        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            try
            {
                LoadData();
            }
            catch (Exception e)
            {
                Toast.makeText(CappingTime.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(CappingTime.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadData() {
        api.capping(MainActivity2.selectedDevice.getId()).enqueue(new Callback<ArrayList<chartValue>>() {
            @Override
            public void onResponse(Call<ArrayList<chartValue>> call, Response<ArrayList<chartValue>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<chartValue> list = response.body();
                    //TODO wyświetlić wykres na podstawie tych danych
                }
                else
                {
                    Toast.makeText(CappingTime.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<chartValue>> call, Throwable t) {
                Toast.makeText(CappingTime.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}