package com.example.bestfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


abstract class ProgressReport : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userrecyclerView: RecyclerView
    private lateinit var userlistdata: ArrayList<UserData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_report)
        userrecyclerView=findViewById(R.id.recyclerview22)
        userrecyclerView.layoutManager = LinearLayoutManager(this)
        userrecyclerView.setHasFixedSize(true)

        userlistdata = arrayListOf()
        getuserdata()

    }

    private fun getuserdata() {

        dbref = FirebaseDatabase.getInstance().getReference("Progress")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (usersnapshot in snapshot.children){
                        val user = usersnapshot.getValue(UserData::class.java)
                        userlistdata.add(user!!)
                    }
                    userrecyclerView.adapter = MyAdapter(userlistdata)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}