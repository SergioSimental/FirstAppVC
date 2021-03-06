package com.example.firstappvc

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

//server ... addition on 2 numbers or location data, ads
class MyService : Service() {
    var TAG = MyService::class.java.simpleName
    private val addBinder = LocalBinder()

    //binder is like pipe through which data flows
    inner class LocalBinder: Binder(){
        //Return this instance of LocalService so clients can call public methods
        public fun getService(): MyService{
            return MyService()
        }
    }


    override fun onCreate(){
        super.onCreate()
        Log.i(TAG, "service created")
    }

    /*
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int):Int{
        super.onStartCommand(intent, flags, startId)
        var name = intent?.getStringExtra("musicfile")
        Log.i(TAG,"i am going to play this " +name)
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()
        return START_STICKY
    }
     */

    override fun onBind(intent: Intent): IBinder?{
        return addBinder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "service destroyed")
    }

    fun add(a:Int, b:Int):Int{
        return a+b
    }
}