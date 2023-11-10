package com.example.garbagemanagementsystem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList:ArrayList<PickupDc>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pickup_item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.userName.text = currentItem.userName
        holder.userPhone.text = currentItem.userPhone
        holder.userAddress.text = currentItem.userAddress
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val userName:TextView = itemView.findViewById(R.id.id_userName)
        val userPhone:TextView = itemView.findViewById(R.id.id_userPhone)
        val userAddress:TextView = itemView.findViewById(R.id.id_userAddress)


    }
}