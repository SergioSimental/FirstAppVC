package com.example.firstappvc

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity(){
    lateinit var wordsRecyclerView: RecyclerView
    var words = arrayOf("first","second","third")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView = findViewById(R.id.wordsRecyclerview)
        var adapter = WordsAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
        wordsRecyclerView.adapter = adapter
    }
    
    private fun adapterOnClick(word: WordsAdapter){
        //Toast.makeText(this, Toast.LENGTH_SHORT).show()
    }
}