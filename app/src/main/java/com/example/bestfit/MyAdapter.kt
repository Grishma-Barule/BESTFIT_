package com.example.bestfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList : ArrayList<UserData>): RecyclerView.Adapter<MyAdapter.MyviewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        val currentitem = userList[position]
        holder.bm.text= currentitem.bmi.toString()
        holder.wet.text= currentitem.wt.toString()
        holder.het.text = currentitem.ht.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }





    class MyviewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val bm : TextView = itemView.findViewById(R.id.textview102)
        val wet : TextView = itemView.findViewById(R.id.textview100)
        val het : TextView = itemView.findViewById(R.id.textView101)

    }
}


