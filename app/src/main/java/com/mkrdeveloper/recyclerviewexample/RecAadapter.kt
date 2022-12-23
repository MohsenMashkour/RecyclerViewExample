package com.mkrdeveloper.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecAadapter(private val pizzaList : ArrayList<Pizza>) : RecyclerView.Adapter<RecAadapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgTitle = itemView.findViewById<ImageView>(R.id.imgTitle)
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvIng = itemView.findViewById<TextView>(R.id.tvIng)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = pizzaList[position]

        holder.imgTitle.setImageResource(currentItem.imageTitle)
        holder.tvName.text = currentItem.name
        holder.tvIng.text = currentItem.ingredients
    }

    override fun getItemCount(): Int {
        return  pizzaList.size
    }
}