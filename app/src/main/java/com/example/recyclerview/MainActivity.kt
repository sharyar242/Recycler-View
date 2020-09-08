package com.example.recyclerview

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure!")
        builder.setMessage("Do you want to close this project?")
        builder.setPositiveButton("Yes")
        { _: DialogInterface, _: Int ->
            finish()
        }
        builder.setNegativeButton("No") { _: DialogInterface, _: Int -> }
        builder.show()
    }

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
            val model = User()
            model.title = "Title ${i+1} "
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }
    fun onOptionsButtonClick(view: View,position: Int){
        val optionsMenu = PopupMenu(this,view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.item_add -> {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Are you sure!")
                    builder.setMessage("Do you want to add new item?")
                    builder.setPositiveButton("Add") { _: DialogInterface, _: Int ->
                        adapter.onItemAdded(position + 1)
                        }
                    builder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
                    }
                    builder.show()
                }
                R.id.item_delete ->{
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("Are you sure!")
                    builder.setMessage("Do you want to delete this item?")
                    builder.setPositiveButton("Delete")
                    { _: DialogInterface, _: Int ->
                        adapter.onItemDeleted(position)
                    }
                    builder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
                    }
                    builder.show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}