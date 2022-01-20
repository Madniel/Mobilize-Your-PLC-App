package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobilizeyourplc.model.SpinAdapter;
import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.device;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends Activity implements View.OnClickListener {

    UserService api;
    SpinAdapter adapter;
    Spinner spinner;
    public static device selectedDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = (Spinner) findViewById(R.id.planets_spinner);
        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this); // calling onClick() method
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        Button twelve = (Button) findViewById(R.id.button12);
        twelve.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this);
        Button ten = (Button) findViewById(R.id.button10);
        ten.setOnClickListener(this);
        Button fifteen = (Button) findViewById(R.id.button15);
        fifteen.setOnClickListener(this);

        selectedDevice = null;
        api = ApiUtils.getApiClient();
        LoadDevices();
    }

    private void LoadDevices() {
        api.getDevices().enqueue(new Callback<ArrayList<device>>() {
            @Override
            public void onResponse(Call<ArrayList<device>> call, Response<ArrayList<device>> response) {
                if(response.isSuccessful())
                {
                    if(response.body().size() == 0)
                    {
                        Toast.makeText(MainActivity2.this,"No devices available..", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        adapter = new SpinAdapter(MainActivity2.this,
                                android.R.layout.simple_spinner_item,
                                response.body().toArray(new device[response.body().size()]));
                        spinner.setAdapter(adapter); // Set the custom adapter to the spinner
                        // You can create an anonymous listener to handle the event when is selected an spinner item
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view,
                                                       int position, long id) {
                                // Here you get the current item (a User object) that is selected by its position
                                selectedDevice = adapter.getItem(position);
                                // Here you can do the action you want to...
                                Toast.makeText(MainActivity2.this, "ID: " + selectedDevice.getId() + "\nName: " + selectedDevice.getName(),
                                        Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapter) {
                                selectedDevice = null;
                            }
                        });
                    }
                }
                else
                {
                    Toast.makeText(MainActivity2.this,"Unable to download devices from the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<device>> call, Throwable t) {
                Toast.makeText(MainActivity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {

        if(selectedDevice == null)
        {
            Toast.makeText(MainActivity2.this, "Device is not selected.",
                Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getId()) {
            case R.id.button12:
                Intent intent = new Intent(this, SetParameters.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(this, Statuses.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(this, StatisticModule.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, AlarmModule.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, ControlModule.class);
                startActivity(intent);
                break;
            case R.id.button15:
                intent = new Intent(this, CappingTime.class);
                startActivity(intent);
                break;
            case R.id.button10:
                intent = new Intent(this, DispenseTime.class);
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(this, FillTime.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
        }
    }


}