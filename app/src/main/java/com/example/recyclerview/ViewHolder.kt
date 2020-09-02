package com.example.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview.view.*

class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){

    private val tvTitle : TextView = itemView.tvTitle
    private val tvDescription : TextView =  itemView.tvDescription

    fun populateModels(user: User, activity: MainActivity, position: Int, size:Int){
        tvTitle.text = user.title
        tvDescription.text = user.description
        itemView.setOnClickListener {
            activity.itemOnClicked(position,size)
        }

        itemView.btnOptions.setOnClickListener {
            activity.onOptionsButtonClick(itemView.btnOptions, position,size)
        }



    }




}