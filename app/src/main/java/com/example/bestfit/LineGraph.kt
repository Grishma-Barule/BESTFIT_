package com.example.bestfit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class LineGraph : AppCompatActivity() {

    var yvalues: ArrayList<Float> = ArrayList()
    lateinit var lineChart: LineChart


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_graph)

        yvalues= intent .getSerializableExtra( "datalo" ) as ArrayList<Float>
        lineChart = findViewById(R.id.linechart)
        setLineChartData()

    }

    fun showtable(view: View) {
        val intent = Intent(this, progresstable::class.java)

        startActivity(intent)
    }

    fun setLineChartData() {
        Log.d("aagaya", "in setlinearchart")

        val xvalues: ArrayList<String> = ArrayList()

        var size = yvalues.size
        Log.d("dekho yvalues ki size",yvalues.size.toString())

        for (i in 0 until size) {
            xvalues.add((i + 1).toString())
            Log.d("xadded", "xadded")

        }

        val lineEntry = ArrayList<Entry>()
        for (i in 0 until size) {
            lineEntry.add(Entry(yvalues[i], i))
            Log.d("yadded", "yadded")
        }



        val linedataset = LineDataSet(lineEntry, "BMI")

        linedataset.lineWidth = 2f
        linedataset.color = R.color.dark_red_2
        val data = LineData(xvalues, linedataset)
        lineChart.data = data
        lineChart.animateXY(3000, 3000)

    }

}