package com.example.bestfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class UserInformation : AppCompatActivity() {

    lateinit var button: Button

    val yvalues: ArrayList<Float> = ArrayList()
    private lateinit var userlistdata: ArrayList<UserData>
    val ref = FirebaseDatabase.getInstance().getReference("Progress")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_information)
        button = findViewById(R.id.button)

        userlistdata = arrayListOf()
        button.setOnClickListener {
            bmicalculate()

        }
    }
    fun showchart(view: View) {
        val intent = Intent(this, LineGraph::class.java)

        Toast.makeText(applicationContext,"Wait!! Setting Linechartdata",Toast.LENGTH_LONG).show()
        getuser()
        Timer("setting up", false).schedule(5000){

            intent.putExtra("datalo",yvalues)
            startActivity(intent)
        }

    }

    private fun bmicalculate() {
        val edtxt1= findViewById<EditText>(R.id.Weight)
        val wt= (edtxt1.text.toString()).toFloat()
        val edtxt2= findViewById<EditText>(R.id.height)
        val ht=((edtxt2.text.toString()).toFloat())/100
        val bmi = ("%.1f".format(wt/(ht*ht))).toFloat()


        val id = ref.push().key.toString()

        val user = UserData(wt,ht*100,bmi)
        ref.child(id).setValue(user).addOnSuccessListener {
          Toast.makeText(applicationContext,"Storing Data",Toast.LENGTH_LONG).show()
        }

        val message= " Your bmi is $bmi"

        val textView = findViewById<TextView>(R.id.bmishow).apply {
            text=message }
        val msg2: String
        if(bmi<=18.4){
            msg2=" You are Underweight , Malnutrition risk"
        }
        else if(bmi>18.4 && bmi<= 24.9){
            msg2="Normal weight, Low risk"
        }
        else if(bmi>24.9 && bmi<= 29.9){
            msg2="Overweight, Enchanced risk"
        }

        else if(bmi>29.9 && bmi<=34.9){
            msg2=" Moderately obese, Medium risk"
        }
        else if(bmi>34.9 && bmi<=39.9){
            msg2="Severely obese, High risk"
        }
        else{
            msg2="Very severely obese, Very high risk"
        }
        val text=findViewById<TextView>(R.id.effectshow).apply {
            text=msg2
        }
    }

    private fun getuser() {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var i = 0
                    for (usersnapshot in snapshot.children) {
                        i += 1
                        val user = usersnapshot.getValue(UserData::class.java)
                        userlistdata.add(user!!)
//                    }
//
//                    for (entries in userlistdata) {

                        yvalues.add(user.bmi)
                        Log.d("useradded", user.bmi.toString())

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}