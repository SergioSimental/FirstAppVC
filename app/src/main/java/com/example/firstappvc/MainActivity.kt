package com.example.firstappvc

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var etName: EditText   //declartion
    lateinit var tvRes: TextView
    lateinit var spinner:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName) //initialization
        tvRes = findViewById(R.id.tvResult)
        spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this
    }

    fun clickHandler(view: View) {
        startCounterActivity()
        //startDialer()
    }

    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732")) //implicit intent
        startActivity(dialIntent)
    }

    private fun startCounterActivity() {
        var intent = Intent(this, CounterActivity::class.java) //explicit intent -- name of the class to be invoked
        var name = etName.text.toString()
        // tvRes.setText(name)
        intent.putExtra("nkey", name)
        startActivityForResult(intent,123)//
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, dataIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, dataIntent)
        var contact = dataIntent?.getStringExtra("ckey")
        tvRes.setText(contact)
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var itemSelected = adapterView?.selectedItem.toString()
        Toast.makeText(this,itemSelected,Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }


}