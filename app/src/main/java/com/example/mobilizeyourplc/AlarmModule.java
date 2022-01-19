package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlarmModule extends Activity  {

    private static final String TAG = "AlarmModule";
    UserService api;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_module);



        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            try
            {
                LoadAlarms(MainActivity2.selectedDevice.getId());
            }
            catch (Exception e)
            {
                Toast.makeText(AlarmModule.this,"Failed to retrieve alarms from the server.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(AlarmModule.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }


        Button ten = (Button) findViewById(R.id.button6);
//        ten.setOnClickListener(this); // calling onClick() method
        Button eleven = (Button) findViewById(R.id.button7);
//        eleven.setOnClickListener(this);

        Log.d(TAG, "onCreate: Started.");
        mListView = (ListView) findViewById(R.id.listView);
    }

    private void LoadAlarms(int id) {

        api.alarms(id).enqueue(new Callback<ArrayList<Alarm>>() {
            @Override
            public void onResponse(Call<ArrayList<Alarm>> call, Response<ArrayList<Alarm>> response) {
                if(response.isSuccessful())
                {
                    //Add the Alarm objects to an ArrayList
                    ArrayList<Alarm> peopleList = response.body();

                    AlarmListAdapter adapter = new AlarmListAdapter(AlarmModule.this, R.layout.activity_alarm_module, peopleList);
                    mListView.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(AlarmModule.this,"Failed to retrieve alarms from the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Alarm>> call, Throwable t) {
                Toast.makeText(AlarmModule.this,"Failed to retrieve alarms from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //    @Override
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
}