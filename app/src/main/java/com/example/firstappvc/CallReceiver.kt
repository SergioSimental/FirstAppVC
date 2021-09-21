package com.example.firstappvc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class CallReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.getStringExtra(TelephonyManager.EXTRA_STATE)) {
            TelephonyManager.EXTRA_STATE_RINGING ->{
                val incomingNumber= intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
                if (incomingNumber != null) {
                    Log.d("Phone Number Calling", incomingNumber)
                }
            }
        }
    }
}