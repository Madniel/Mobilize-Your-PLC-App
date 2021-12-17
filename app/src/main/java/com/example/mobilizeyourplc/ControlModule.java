package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ControlModule extends Activity implements View.OnClickListener {

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_module);

        inputText = (EditText) findViewById(R.id.input);

        Button eight = (Button) findViewById(R.id.button6);
        eight.setOnClickListener(this); // calling onClick() method
        Button nine = (Button) findViewById(R.id.button7);
        nine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button8:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button9:
                intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.send:
                // To DO
                break;
            default:
                break;
        }
    }
}