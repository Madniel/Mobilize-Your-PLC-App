package com.example.mobilizeyourplc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.parameter;
import com.example.mobilizeyourplc.remote.standardRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetParameters extends AppCompatActivity {
    UserService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_parameters);
        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            LoadParameters();
        }
        else
        {
            Toast.makeText(SetParameters.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadParameters() {
        api.parameters(new standardRequest(MainActivity2.selectedDevice.getId())).enqueue(new Callback<ArrayList<parameter>>() {
            @Override
            public void onResponse(Call<ArrayList<parameter>> call, Response<ArrayList<parameter>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<parameter> list = response.body();

                    //TODO listę parametrów wyświetlić na widoku.
                }
                else
                {
                    Toast.makeText(SetParameters.this,"Failed to retrieve parameters from the server.", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<parameter>> call, Throwable t) {
                Toast.makeText(SetParameters.this,"Failed to retrieve parameters from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //TODO wywołać tą metodę po kliknięciu send!!!
    private void SetParameters(ArrayList<parameter> list)
    {
        if(list != null && list.size() > 0)
        {
            api.setParameters(list).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful())
                    {
                        Toast.makeText(SetParameters.this,"The parameters have been set.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SetParameters.this,"Parameters cannot be set.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(SetParameters.this,"Parameters cannot be set.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}