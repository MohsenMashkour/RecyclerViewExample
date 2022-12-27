package com.mkrdeveloper.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecAadapter(private val pizzaList : ArrayList<Pizza>) : RecyclerView.Adapter<RecAadapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgTitle: ImageView = itemView.findViewById(R.id.imgTitle)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvIng: TextView = itemView.findViewById(R.id.tvIng)
        val constraint_row : ConstraintLayout = itemView.findViewById(R.id.constraint_row)
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

        val cont = holder.constraint_row.context
        holder.constraint_row.setOnClickListener {
            Toast.makeText(cont, "the item ${currentItem.name} is clicked", Toast.LENGTH_SHORT).show()
        }


        holder.constraint_row.setOnLongClickListener(View.OnLongClickListener {
            Toast.makeText(cont, "the item ${currentItem.name} is long clicked", Toast.LENGTH_SHORT).show()

            return@OnLongClickListener true
        })
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }
}