package com.example.mobilizeyourplc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControlModule extends Activity implements View.OnClickListener {

    EditText inputText;
    UserService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_module);

        inputText = (EditText) findViewById(R.id.input);

        Button eight = (Button) findViewById(R.id.send);
        eight.setOnClickListener(this); // calling onClick() method

        Button nine = (Button) findViewById(R.id.button8);
        nine.setOnClickListener(this);

        api = ApiUtils.getApiClient();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button8:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.send:
                SendMessage();
                break;
            default:
                break;
        }
    }

    private void SendMessage() {
        if(MainActivity2.selectedDevice != null)
        {
            String text = inputText.getText().toString();

            api.message(new message(text, MainActivity2.selectedDevice.getId())).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.isSuccessful())
                    {
                        Toast.makeText(ControlModule.this, "Message was sent.", Toast.LENGTH_SHORT).show();
                        inputText.getText().clear();
                    }
                    else
                    {
                        Toast.makeText(ControlModule.this, "The message could not be sent.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(ControlModule.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Toast.makeText(ControlModule.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }
    }
}