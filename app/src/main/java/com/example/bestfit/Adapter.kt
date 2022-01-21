package com.example.bestfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (val userlist: ArrayList<user> ): RecyclerView.Adapter<Adapter.Viewholder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val v = LayoutInflater.from(parent.context).inflate( R.layout.list_layout,parent,false )
        return Viewholder(v)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
          val User : user = userlist[position]
        holder.textviewexercise.text = User.exercise
        holder.textviewcalories.text = User.calories
        holder.imageicon.setImageResource(User.icon)
    }

    override fun getItemCount(): Int {
       return  userlist.size

    }
    class Viewholder(itemview : View) : RecyclerView.ViewHolder(itemview){
    val textviewexercise = itemView.findViewById(R.id.exercise) as TextView
        val textviewcalories = itemview.findViewById(R.id.calories) as TextView
        val imageicon = itemview.findViewById(R.id.imagecir) as ImageView

}}