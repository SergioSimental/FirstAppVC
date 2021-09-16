package com.example.firstappvc;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//ip type cityName -- string
public class FetchCityTask extends AsyncTask<String, Void, String> {
    TextView cityTv, weatherTV;

    public FetchCityTask(TextView mCityText, TextView mWeatherTv){
        cityTv = mCityText;
        weatherTV = mWeatherTv;
    }

    @Override
    protected String doInBackground(String... cityName){
        return WeatherUtils.getCityInfo(cityName[0]);
    }

    @Override
    protected void onPostExecute(String jsonString){
        super.onPostExecute(jsonString);

        try{
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray weatherJSONArray = jsonObject.getJSONArray("weather");
            for (int i =0; i < weatherJSONArray.length(); i++){
                JSONObject weather = weatherJSONArray.getJSONObject(i);
                String cityW = weather.getString("description");
                weatherTV.setText(cityW);
            }

            /*
            for (int i =0; i < weatherJSONArray.length(); i++){
                JSONObject weather = weatherJSONArray.getJSONObject(i);
                String cityN = weather.getString("description");
                cityTv.setText(cityN);
            }
            */

        } catch (JSONException e){
            e.printStackTrace();
        }
    }



}
