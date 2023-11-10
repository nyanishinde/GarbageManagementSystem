package com.example.garbagemanagementsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter2(private val userList2:ArrayList<Complain>): RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter2.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.complain_item,
            parent,false)
            return MyAdapter2.MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList2.size
    }

    override fun onBindViewHolder(holder: MyAdapter2.MyViewHolder, position: Int) {
        val currentItem = userList2[position]
        holder.complainName.text = currentItem.complainName
        holder.complainPhone.text = currentItem.complainPhone
        holder.complainAddress.text = currentItem.complainAddress
        holder.complainDetails.text = currentItem.complainDetails
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val complainName: TextView = itemView.findViewById(R.id.id_complainName)
        val complainPhone: TextView = itemView.findViewById(R.id.id_complainPhone)
        val complainAddress: TextView = itemView.findViewById(R.id.id_complainAddress)
        val complainDetails: TextView = itemView.findViewById(R.id.id_complainDetails)

    }

}