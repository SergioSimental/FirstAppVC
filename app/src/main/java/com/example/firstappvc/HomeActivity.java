package com.example.firstappvc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button toastButton;
    String[] languages = {"english","french","arabic"}; //data-- plug
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView langsListView = findViewById(R.id.languageslv); //socket

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,languages);
        langsListView.setAdapter(adapter);


        toastButton = findViewById(R.id.btnMessage);
        //clerk.getSomething(mobilePhone)
        toastButton.setOnClickListener(this); //button is user who's clicking the switch onclick

        Spinner countriesSpinner = findViewById(R.id.spinnerCountries);
        countriesSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.miFirst:
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miSecond:
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();

                break;
            case R.id.miThird:
                Toast.makeText(this, "third", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) { //switch
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
       /* SmsManager  manager = SmsManager.getDefault();
        manager.sendTextMessage("5556",null,"your otp is",null,null);*/
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String itemSelected = adapterView.getSelectedItem().toString();
        Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}