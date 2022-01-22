package com.example.bestfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class mainworkout : AppCompatActivity() {

    lateinit var buttonProfile: Button
     lateinit var buttonworkouts : Button
     lateinit var buttonBMI : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_workout)
        val email = intent.getStringExtra("email")
        buttonProfile = findViewById(R.id.Profile)

        buttonworkouts = findViewById(R.id.button2)

        buttonBMI=findViewById(R.id.button)



        buttonworkouts.setOnClickListener {
            val intent= Intent(applicationContext,workout::class.java)
            startActivity(intent)
        }
        buttonBMI.setOnClickListener {
            val intent101= Intent(applicationContext,UserInformation::class.java)
            startActivity(intent101)
        }
        buttonProfile.setOnClickListener{

            val intent512 = Intent(this, LoggedIn::class.java)
            intent512.putExtra("email",email)
            startActivity(intent512)

        }

        }

    }
