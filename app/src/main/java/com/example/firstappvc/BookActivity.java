package com.example.firstappvc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {
    EditText mBookInput;
    TextView mTitleText, mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }


    public void searchBooksAPI(View view) {
        String bookName = mBookInput.getText().toString();
        FetchBookTask fetchBookTask = new FetchBookTask(mTitleText, mAuthorText);
        fetchBookTask.execute(bookName);
    }
}