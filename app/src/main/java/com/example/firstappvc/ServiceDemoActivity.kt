package com.example.firstappvc

import android.app.*
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat

//client
class ServiceDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_demo)
    }

    fun serviceHandler(view: View){
        when(view.id){
            R.id.btnStartServ ->{
                var serviceIntent: Intent = Intent(this, MyService::class.java)
                //serviceIntent.putExtra("musicfile", "mymusic.mp3")

                //startService(serviceIntent) // create a service object

                bindService(serviceIntent, connection, BIND_AUTO_CREATE)
            }
            R.id.btnStop ->{
                var serviceIntent1: Intent = Intent(this, MyService::class.java)
                stopService(serviceIntent1)
            }

        }
    }

    private lateinit var mService: MyService

    //serviceConnection like a contract
    private val connection = object : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, addBinder: IBinder?){
            val binder = addBinder as MyService.LocalBinder
            mService = binder.getService() //i am not creating a new object instead i am binding to an existing object and consuming its services
            var result = mService.add(10, 25)
            Toast.makeText(applicationContext, "result = " + result, Toast.LENGTH_SHORT).show()
            //Log.i("Result = ", result.toString())
        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }
    }

    fun sendNotifiticaton(view: View) {
        createNotificationChannel()
        val intent = Intent(this, CounterActivity::class.java).apply{
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        var builder = NotificationCompat.Builder(this, "simple notifis")
            .setSmallIcon(R.drawable.ic_notify_foreground)
            .setContentTitle("some title")
            .setContentText("some text")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)


        var notification : Notification = builder.build()
        val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(123, notification)
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("simple notifis", name, importance).apply{
                description = descriptionText
            }
            val notificationManager: NotificationManager = 
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


}