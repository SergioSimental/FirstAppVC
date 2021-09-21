package com.example.firstappvc

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class CounterActivity : AppCompatActivity() {
    var TAG = CounterActivity::class.java.simpleName
    //TODO: Add Abdullah's method!
    lateinit var tvCounter: TextView
    var counter = 0
    lateinit var etContact:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        Log.i(TAG,"oncreate")
        tvCounter = findViewById(R.id.tvCounter)
        etContact = findViewById(R.id.etContact)
        /* var name = intent.getStringExtra("nkey")
         tvCounter.setText(name)*/
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onstart")


        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new FCM registration token
                val token: String = task.getResult().toString()

                // Log and toast
                //val msg = getString(R.string.msg_token_fmt, token)
                Log.d(TAG, token)
                Toast.makeText(this, token, Toast.LENGTH_SHORT).show()
            })

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"onpause")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"onResume")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"ondestroy")

    }




    fun updateCounter(view: View) {
        var seconds = Integer.parseInt(etContact.text.toString())
        startTimer("sample",seconds)
        /*var currentValue = Integer.parseInt(tvCounter.text.toString())
        tvCounter.setText(""+counter++)*/
    }

    fun showToast(view: View) {
        var contact = etContact.text.toString()
        var intent = Intent()
        intent.putExtra("ckey",contact)
        setResult(RESULT_OK,intent)
        finish()
        //Toast.makeText(this,""+counter++,Toast.LENGTH_SHORT).show()
    }

    fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun setAlarm(view: View){
        var alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        var intent: Intent = Intent(this, HomeActivity::class.java)
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 123, intent, PendingIntent.FLAG_ONE_SHOT)
        var oneMin: Long = 1*60*1000;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ oneMin, oneMin, pendingIntent)
    }

    fun sendSMS(view: View) {
        var alarmManager: AlarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        var intent: Intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("sms" , "Happy Birthday")
        intent.putExtra("number", 5556)
        var pendingIntent: PendingIntent = PendingIntent.getActivity(this, 123, intent, PendingIntent.FLAG_ONE_SHOT)
        var oneMin: Long = 1*60*1000;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+ oneMin, oneMin, pendingIntent)

    }
}
