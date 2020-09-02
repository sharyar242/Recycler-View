package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.delete

class ListAdapter(private val activity: MainActivity):RecyclerView.Adapter<ViewHolder>() {

    var models: MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>) {
        this.models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.models.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModels(models[position], activity, models.size, position)
    }

    fun onItemDeleted(size: Int) {
        models.removeAt(size)
        notifyItemRemoved(size)
    }
}