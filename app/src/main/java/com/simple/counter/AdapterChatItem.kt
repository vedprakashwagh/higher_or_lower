package com.simple.counter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.simple.counter.model.ModelChat

class AdapterChatItem : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItems: List<ModelChat>? = null

    fun updateList(listItems: List<ModelChat>?){
        this.listItems = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderListItemChat(LayoutInflater.from(parent.context).inflate(R.layout.list_item_chat, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var chatItem = holder as ViewHolderListItemChat
        var currentChatItem = listItems?.get(position)
        chatItem.chatName.text = currentChatItem?.userName
        chatItem.chatMessage.text = currentChatItem?.userMessage

    }

    override fun getItemCount(): Int {
        return listItems?.size ?: 0
    }


    class ViewHolderListItemChat(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profilePicture : RoundedImageView =  itemView.findViewById(R.id.profilePicture)
        var chatMessage: TextView = itemView.findViewById(R.id.chatMessage)
        var chatName: TextView = itemView.findViewById(R.id.chatName)
        var chatMessageTime: TextView = itemView.findViewById(R.id.chatMessageTime)
        var unreadMessageCountHolder : FrameLayout = itemView.findViewById(R.id.unreadMessageCountHolder)
        var unreadMessageCount: TextView = itemView.findViewById(R.id.unreadMessageCount)
    }

}