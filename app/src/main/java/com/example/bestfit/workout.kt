package com.example.bestfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import kotlinx.android.synthetic.main.activity_workout.*

class workout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        val time = findViewById<EditText>(R.id.editTextt).text
        val weight = findViewById<EditText>(R.id.editTextW).text
        lateinit var buttonexercise : Button
        buttonexercise = findViewById(R.id.buttonex)
        buttonexercise.setOnClickListener {
            val intent: Intent = Intent(applicationContext,MainActivity2list::class.java)
                if(time.isNotEmpty() && weight.isNotEmpty() ) {
                    val timeee = time.toString().toDouble()
                    val weightii = weight.toString().toDouble()

                        intent.putExtra("TIME", timeee)
                        intent.putExtra("WEIGHT", weightii)
                        startActivity(intent)
                }else{
                    Toast.makeText(getBaseContext(),"Input Field is Empty", Toast.LENGTH_LONG).show();
                }


        }
    }
}