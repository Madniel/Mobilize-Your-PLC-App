package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AlarmModule extends Activity implements View.OnClickListener {

    private static final String TAG = "AlarmModule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_module);

        Button ten = (Button) findViewById(R.id.button6);
        ten.setOnClickListener(this); // calling onClick() method
        Button eleven = (Button) findViewById(R.id.button7);
        eleven.setOnClickListener(this);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Alarm objects
        Alarm undfvar = new Alarm("Undefined Variable","14:09 12-16-2021");
        Alarm value = new Alarm("Value out of range","15:15 12-16-2021");

        //Add the Alarm objects to an ArrayList
        ArrayList<Alarm> peopleList = new ArrayList<>();
        peopleList.add(undfvar);
        peopleList.add(value);

        AlarmListAdapter adapter = new AlarmListAdapter(this, R.layout.activity_alarm_module, peopleList);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button10:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button11:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.button12:
                break;
            case R.id.button13:
                break;
            default:
                break;
        }
    }
}