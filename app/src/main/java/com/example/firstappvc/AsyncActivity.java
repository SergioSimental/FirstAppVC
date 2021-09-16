package com.example.firstappvc;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class AsyncActivity extends AppCompatActivity {
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mProgressBar = findViewById(R.id.progressBar);
    }

    public void downloadMovie(View view){ //task that will be ran
        String movieUrl = "http://mymovie.com";
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute(movieUrl);
    }
}
