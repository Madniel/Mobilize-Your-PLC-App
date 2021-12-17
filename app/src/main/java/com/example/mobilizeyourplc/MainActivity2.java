package com.example.mobilizeyourplc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Button five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(this); // calling onClick() method
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                Intent intent = new Intent(this, MainActivity.class);
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
            default:
                break;
        }
    }


}