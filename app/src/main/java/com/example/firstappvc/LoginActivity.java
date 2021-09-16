package com.example.firstappvc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView resTextView;
    EditText etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        resTextView = findViewById(R.id.tvRes);
        etEmail = findViewById(R.id.etEmail);
    }

    public void setTextView(View view){
        String email = etEmail.getText().toString();
        resTextView.setText(email);
    }
}