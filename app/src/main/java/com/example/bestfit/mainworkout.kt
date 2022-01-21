package com.example.bestfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class mainworkout : AppCompatActivity() {

     lateinit var buttonworkouts : Button
     lateinit var buttonBMI : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_workout)
        buttonworkouts = findViewById(R.id.button2)

        buttonBMI=findViewById(R.id.button)
        buttonworkouts.setOnClickListener {
            val intent: Intent = Intent(applicationContext,workout::class.java)
            startActivity(intent)
        }
        buttonBMI.setOnClickListener {
            val intent101: Intent = Intent(applicationContext,UserInformation::class.java)
            startActivity(intent101)
        }



    }
}
