package com.example.firstappvc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {
    EditText mCityInput;
    TextView mWeatherText, mCityText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mCityInput = findViewById(R.id.cityInput);
        mWeatherText = findViewById(R.id.temperature);
        mCityText =  findViewById(R.id.cityText);
    }

    public void searchWeatherAPI(View view) {
        String cityName = mCityInput.getText().toString();
        String weather = mWeatherText.getText().toString();
        FetchCityTask fetchCityTask = new FetchCityTask(mCityText, mWeatherText);
        fetchCityTask.execute(cityName);
    }
}