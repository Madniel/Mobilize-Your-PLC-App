package com.example.mobilizeyourplc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openMainPage(view);
            }
        });
    }

    public void openMainPage(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}