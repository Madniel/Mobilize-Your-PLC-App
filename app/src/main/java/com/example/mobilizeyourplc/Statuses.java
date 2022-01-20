package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.status;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Statuses extends Activity implements View.OnClickListener {

    UserService api;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statuses);
        Button ten = (Button) findViewById(R.id.button10);
        ten.setOnClickListener(this);


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

        mListView = (ListView) findViewById(R.id.listView);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button10:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
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
                    StatusesListAdapter adapter = new StatusesListAdapter(Statuses.this, R.layout.activity_statuses_list, list);
                    mListView.setAdapter(adapter);
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