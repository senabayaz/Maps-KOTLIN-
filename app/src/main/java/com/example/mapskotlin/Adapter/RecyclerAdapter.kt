package com.example.mapskotlin.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mapskotlin.MapsActivity
import com.example.mapskotlin.databinding.RecyclerRowBinding
import com.example.mapskotlin.room.Maps

class RecyclerAdapter(val list : List<Maps>) : RecyclerView.Adapter<RecyclerAdapter.holder>() {

    class holder(val recyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return holder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: holder, position: Int) {
        holder.recyclerRowBinding.txt.text = list.get(position).title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,MapsActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}