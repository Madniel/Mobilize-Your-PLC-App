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
import com.example.mobilizeyourplc.remote.parameter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetParameters extends Activity implements View.OnClickListener {
    ArrayList<parameter> list = new ArrayList<parameter>();
    UserService api;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_parameters);

        Button four = (Button) findViewById(R.id.send);
        four.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.button8);
        two.setOnClickListener(this);


        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            try
            {
                LoadParameters();
            }
            catch (Exception e)
            {
                Toast.makeText(SetParameters.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(SetParameters.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }

        mListView = (ListView) findViewById(R.id.listView);
    }

    private void LoadParameters() {
        api.parameters(MainActivity2.selectedDevice.getId()).enqueue(new Callback<ArrayList<parameter>>() {
            @Override
            public void onResponse(Call<ArrayList<parameter>> call, Response<ArrayList<parameter>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<parameter> list = response.body();

                    //TODO listę parametrów wyświetlić na widoku.
                    ParametersListAdapter adapter = new ParametersListAdapter(SetParameters.this, R.layout.activity_set_parameters_list, list);
                    mListView.setAdapter(adapter);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                SetParameters(list);
                Intent intent = new Intent(this, SetParameters.class);
                startActivity(intent);
                break;
            case R.id.button8:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, SetParameters.class);
                startActivity(intent);
                break;
        }
    }
}