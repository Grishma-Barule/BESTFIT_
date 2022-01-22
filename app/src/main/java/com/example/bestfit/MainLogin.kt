package com.example.bestfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainLogin : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var Register : Button
    lateinit var Login : Button
    lateinit var Email :EditText
    lateinit var Password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)
        Register =findViewById(R.id.Register)
        Login= findViewById(R.id.Login)
        Email = findViewById(R.id.Email)
        Password = findViewById(R.id.Password)
        auth= FirebaseAuth.getInstance()
        Register.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
        Login.setOnClickListener {
            if (checking()) {
                val email = Email.text.toString()
                val password = Password.text.toString()
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Logged In Successfully", Toast.LENGTH_LONG).show()
                            var intent = Intent(this, mainworkout::class.java)
                            intent.putExtra("email",email)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this, "Incorrect Details", Toast.LENGTH_LONG).show()
                        }

                    }
            }
            else{
                Toast.makeText(this,"Enter the details", Toast.LENGTH_LONG).show()
            }

        }
    }
    private fun checking():Boolean {
        if (Email.text.toString().trim{it<=' '}.isNotEmpty()
            && Password.text.toString().trim{it<=' '}.isNotEmpty()){
            return true
        }
        return false

    }


}