package com.example.firstappvc;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherUtils {
//api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

    private static final String LOG_TAG = WeatherUtils.class.getSimpleName();

    private static final String WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    private static final String QUERY_PARAM = "q";
    private static final String API_KEY = "apiid";

    public static String getCityInfo(String cityName){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String weatherJSONString = null;

        try{
            Uri builtURI = Uri.parse(WEATHER_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, cityName)
                    .appendQueryParameter(API_KEY, "17e9fc4e10ac6189c0d34216a40831b1")
                    .build();

            String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=17e9fc4e10ac6189c0d34216a40831b1";

            URL requestURL = new URL(weatherUrl);

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if(inputStream == null){
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line= reader.readLine()) != null){
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0){
                return null;
            }
            weatherJSONString = buffer.toString();
            Log.i(LOG_TAG, requestURL.toString());

        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        } finally{
            if (urlConnection != null){
                urlConnection.disconnect();
            }
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.d(LOG_TAG, weatherJSONString);
            return weatherJSONString;
        }

    }

}

