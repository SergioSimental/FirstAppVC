package com.example.firstappvc;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

//input type = url = string, progress type = int, result type
public class DownloadTask extends AsyncTask<String,Integer, Void>{
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar progressBar;

    public DownloadTask(ProgressBar mProgressBar){
        progressBar = mProgressBar;
    }

    @Override
    protected void onPreExecute() { //runs on the ui thread
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(String... strings){ // this method will run on a background worker thread
        Log.i(TAG, "downloading--" + strings[0]);
        for (int i = 1; i < 21; i++) {
            publishProgress(i * 5); // sending message
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values){ //receiving message -- this method runs on ui thread
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
