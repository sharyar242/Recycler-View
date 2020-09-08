package com.example.recyclerview

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val activity: MainActivity):RecyclerView.Adapter<ViewHolder>() {

    private var models: MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>) {
        this.models = data
        notifyDataSetChanged()
    }

    fun onItemAdded(position: Int){
        models.add(position,User("Title ${models.size+1}","Description ${models.size+1}"))
        notifyItemInserted(position)
        notifyItemRangeChanged(position,models.size)

    }

    fun onItemDeleted(position: Int) {
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,models.size)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.models.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModels(models[position],position,activity)
    }


}