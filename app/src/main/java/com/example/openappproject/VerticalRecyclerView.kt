package com.example.openappproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class VerticalRecyclerView(val itemList: MutableList<VerticalRecyclerViewData>) :
    RecyclerView.Adapter<VerticalRecyclerView.ViewHolder>() {

    class ViewHolder(item : View) : RecyclerView.ViewHolder(item)  {
        var icon : ImageView = itemView.findViewById(R.id.imageView2)
        var link : TextView = itemView.findViewById(R.id.sampleLink)
        var dataTime : TextView = itemView.findViewById(R.id.time)
        var totalClicks : TextView = itemView.findViewById(R.id.clicks)
        var webLink : TextView = itemView.findViewById(R.id.smart_link)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.vertical_recycler_view,parent,false)
        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        Log.d("TAG", "onBindViewHolder: $item")
        holder.link.text = item.smart_link
        holder.dataTime.text = item.created_At
        holder.totalClicks.text = item.total_clicks
        holder.webLink.text = item.webLink
        Glide.with(holder.icon.context).load(item.original_link.toUri()).error(R.drawable.error_image).into(holder.icon)
    }
}