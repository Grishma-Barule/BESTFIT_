package com.example.bestfit

import android.content.Intent
import android.icu.lang.UCharacter
import android.os.Bundle
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_workout.*

class MainActivity2list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2list)

        val intent = intent
        val time = intent.getDoubleExtra("TIME",0.0)
        val weight = intent.getDoubleExtra("WEIGHT",0.0)
        val meta = (time*weight*3.5)/200

        val recyclerview = findViewById(R.id.recyclerView) as RecyclerView
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val metE = arrayOf(5.0,3.5,4.6,4.5,7.0,6.0,2.5,3.0,9.0,4.5,8.8,2.9,5.0,6.0,3.5,4.0,4.4,4.0,4.0,6.0,3.5,9.8,7.6,3.8,4.0,5.0,9.0,8.5,8.0,5.8,6.0,10.0,8.5,2.5,6.0,4.5,5.0,3.0,3.4,6.0,6.0,6.0,4.0)
        fun multiplyByMet(array: Array<Double>) {
            for (i in array.indices) {
                array[i] = array[i] * meta
            }
        }
        multiplyByMet(metE)
        val metc = metE.map { it.toInt()}.toTypedArray()

        val stringArray = metc.map { it.toString() }.toTypedArray()
        val exercises = arrayOf("Aerobics", "Archery", "Badminton", "Basketball","Bicycle", "Bicycle   (indoor)","Billiards",
            "Bowling","Boxing ","Calisthenics ","Climbing   (rock) ","Dancing ","Elliptical","Fencing","Fishing ","Gardening ","Golfing ","Gymnastics ","Horse Riding",
            "Hiking ","Household Chores","Jogging ","Martial Arts","Pilates ","Ping pong ","Rappelling","Running ","Soccer"
            ,"Skating","Skiing","Skipping", "Stairs climbing","Stretching ","Surfing",
            "Swimming","Tennis"," Volleyball" ,"Walking","Weightlifting","Wrestling" ,"Yoga"
        )

        val images = arrayOf(R.drawable.aer,R.drawable.arc,R.drawable.bad,R.drawable.bkball,R.drawable.bi,R.drawable.inbi,
            R.drawable.billiards,R.drawable.bow,R.drawable.box,
            R.drawable.aer,R.drawable.climb,R.drawable.dance,R.drawable.ell,R.drawable.fencing,
            R.drawable.fish,R.drawable.gar,R.drawable.golf,R.drawable.gymnas,R.drawable.horse,R.drawable.hiking,
            R.drawable.house,R.drawable.jogging,R.drawable.ma,R.drawable.pilates,R.drawable.ping,R.drawable.rappell,
            R.drawable.running,R.drawable.soccer,R.drawable.skating,R.drawable.skiing,R.drawable.skipping,R.drawable.stairs,R.drawable.stretch,R.drawable.surfing,
            R.drawable.swim,R.drawable.tennis,R.drawable.volley,R.drawable.walk,R.drawable.weli,R.drawable.wrest,R.drawable.yoga
        )
        val users = arrayListOf<user>()
        for( i in 0..40) {
            users.add(user(exercises[i], stringArray[i]+" Kcal", images[i]))
        }
        val adapter = Adapter(users)
        recyclerview.adapter = adapter
    }
}