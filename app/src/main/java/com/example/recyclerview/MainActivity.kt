package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter:ListAdapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.adapter =adapter
        recycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recycleView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        setData()
    }

    private fun setData(){
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until 1) {
            val model: User = User()
            model.title = "Title ${i+1} "
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View,position: Int,size: Int){
        val optionsMenu = PopupMenu(this,view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.item_add -> {
                    click(position)
                }
                R.id.item_delete ->{
                    adapter.onItemDeleted(size)
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }

    fun itemOnClicked(position: Int, size: Int){
        clicked(position,size)
    }
    
    private fun clicked (size: Int, position: Int) {
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until position+size+1) {
            val model: User = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1} "
            models.add(model)
        }
        adapter.setData(models)
    }

    private fun click (position: Int ) {
        val models: MutableList<User> = mutableListOf()
        for (i in 0 until position+1) {
            val model: User = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1} "
            models.add(model)
        }
        adapter.setData(models)
    }



}