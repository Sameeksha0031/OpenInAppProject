package com.example.openappproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorizontalRecyclerView(val itemList: MutableList<String>) :
    RecyclerView.Adapter<HorizontalRecyclerView.ViewHolder>() {

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)  {
        var icon : ImageView = itemView.findViewById(R.id.horizontal_icon)
        var textOne : TextView = itemView.findViewById(R.id.horizontal_text)
        var textTwo : TextView = itemView.findViewById(R.id.horizontal_text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_for_horizontal_recycler_view,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        Log.d("TAG", "onBindViewHolder: $item")
        when(position){
            0 -> {holder.icon.setImageResource(R.drawable.total_clicks)
                holder.textTwo.text = "Total Click's"
            }
            1 -> {holder.icon.setImageResource(R.drawable.location)
                holder.textTwo.text = "Top Location"
            }
            2 -> {holder.icon.setImageResource(R.drawable.global)
                holder.textTwo.text = "Top Source"
            }
        }
        holder.textOne.text = item
    }
}