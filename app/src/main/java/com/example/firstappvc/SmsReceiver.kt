package com.example.firstappvc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent){
        //This method is called when the Broadcast Receiver is receiving an Intent broadcast.
        Toast.makeText(context, "abdul you have an sms sergio", Toast.LENGTH_SHORT).show()
    }
}