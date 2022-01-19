package com.example.mobilizeyourplc;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilizeyourplc.remote.ApiUtils;
import com.example.mobilizeyourplc.remote.UserService;
import com.example.mobilizeyourplc.remote.chartValue;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PicksCompleted extends AppCompatActivity {

    UserService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picks_completed);
        api = ApiUtils.getApiClient();
        if(MainActivity2.selectedDevice != null)
        {
            try
            {
                LoadData();
            }
            catch (Exception e)
            {
                Toast.makeText(PicksCompleted.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(PicksCompleted.this, "Device is not selected.", Toast.LENGTH_SHORT).show();
        }
    }

    private void LoadData() {
        api.picks(MainActivity2.selectedDevice.getId()).enqueue(new Callback<ArrayList<chartValue>>() {
            @Override
            public void onResponse(Call<ArrayList<chartValue>> call, Response<ArrayList<chartValue>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<chartValue> list = response.body();
                    //TODO wyświetlić wykres na podstawie tych danych
                    BarChart barChart = findViewById(R.id.barChart);
                    ArrayList<BarEntry> datas = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++){
                        int value = list.get(i).getValue();
                        String info = list.get(i).getStringTime();
                        datas.add(new BarEntry(Float.parseFloat(info), value));
                    }

                    BarDataSet barDataSet = new BarDataSet(datas, "Capping Time");
                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                    barDataSet.setValueTextColor(Color.BLACK);
                    barDataSet.setValueTextSize(16f);

                    BarData barData = new BarData((barDataSet));

                    barChart.setFitBars(true);
                    barChart.setData(barData);
                    barChart.getDescription().setText("Bar Chart Example");
                    barChart.animateY(2000);
                }
                else
                {
                    Toast.makeText(PicksCompleted.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<chartValue>> call, Throwable t) {
                Toast.makeText(PicksCompleted.this,"Failed to retrieve data from the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}