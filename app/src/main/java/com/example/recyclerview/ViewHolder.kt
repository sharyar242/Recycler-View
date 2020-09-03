package com.example.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview.view.*

class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

    private val tvTitle : TextView = itemView.tvTitle
    private val tvDescription : TextView =  itemView.tvDescription

    fun populateModels(user: User, position: Int, activity: MainActivity){
        tvTitle.text = user.title
        tvDescription.text = user.description
        itemView.btnOptions.setOnClickListener {
            activity.onOptionsButtonClick(itemView.btnOptions, position)
        }
    }




}