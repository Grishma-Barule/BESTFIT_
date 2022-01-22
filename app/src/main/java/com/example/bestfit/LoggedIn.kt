package com.example.bestfit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class LoggedIn : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    lateinit var logout :Button
    lateinit var name: TextView
    lateinit var phone:TextView
    lateinit var emailLog:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        val email = intent.getStringExtra("email")
        logout =findViewById(R.id.logout)
        name = findViewById(R.id.name)
        phone=findViewById(R.id.phone)
        emailLog = findViewById(R.id.emailLog)
        setText(email)
        logout.setOnClickListener {
            var intent1001 = Intent(this,MainLogin::class.java)
            startActivity(intent1001)
            finish()
        }

    }
    private fun setText(email:String?)
    {
        db= FirebaseFirestore.getInstance()
        if (email != null) {
            db.collection("USERS").document(email).get()
                .addOnSuccessListener {
                        tasks->
                    name.text=tasks.get("Name").toString()
                    phone.text=tasks.get("Phone").toString()
                    emailLog.text=tasks.get("email").toString()

                }
        }

    }
}