package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.reservedtables.R

class Adapter constructor(private val values: List<String>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    override fun getItemCount(): Int = values.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder?.textView?.text = values[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textView: TextView? = null
        init{
            textView = itemView.findViewById(R.id.text_list_item)
        }
    }

}