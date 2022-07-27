package com.simple.counter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterNames(val names: Array<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderListItemName(LayoutInflater.from(parent.context).inflate(R.layout.list_item_name, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolderListItemName
        viewHolder.name.text = names?.get(position).toString()
    }

    override fun getItemCount(): Int {
        if(names == null){
            return 0
        } else {
            return names.size
        }
    }


    class ViewHolderListItemName(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.name)
    }

}