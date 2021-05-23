package com.example.minesweeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result_of_the_game.*

class Result_of_the_game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_of_the_game)
        var intent = getIntent()
        var showname = intent.getStringExtra("player_name")
        var showreuslt = intent.getStringExtra("result")

        show_name.text=showname
        show_result.text = showreuslt

        home.setOnClickListener{
            Toast.makeText(this,"THANK YOU FOR PLAYING",Toast.LENGTH_LONG).show()
            val intent = Intent(this,MainActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }
}