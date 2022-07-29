package com.simple.counter

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import com.simple.counter.model.ModelChat
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

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
        Glide.with(holder.itemView.context).load(currentChatItem?.imageUrl).into(holder.profilePicture)
        chatItem.chatMessageTime.text = getFormattedTime(currentChatItem?.time ?: 0)
        chatItem.unreadMessageCount.text = currentChatItem?.numberOfMessages?.toString()

        if(currentChatItem?.numberOfMessages == 0){
            chatItem.unreadMessageCountHolder.visibility = View.GONE
            chatItem.chatMessageTime.setTextColor(Color.parseColor("#aaaaaa"))
            chatItem.chatMessageTime.setTypeface(null, Typeface.NORMAL)
        } else {
            chatItem.unreadMessageCountHolder.visibility = View.VISIBLE
            chatItem.chatMessageTime.setTextColor(Color.parseColor("#ff99cc00"))
            chatItem.chatMessageTime.setTypeface(null, Typeface.BOLD)
        }

        chatItem.itemView.setOnClickListener {
            val intent = Intent(chatItem.itemView.context, ActivityUserInfo::class.java)
            intent.putExtra("CHAT_NAME", currentChatItem?.userName)
            intent.putExtra("PROFILE_PIC", currentChatItem?.imageUrl)
            intent.putExtra("MESSAGE", currentChatItem?.userMessage)
            chatItem.itemView.context.startActivity(intent)
        }

    }

    fun getFormattedTime(timestamp: Long): String{
        val simpleDateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        return simpleDateFormat.format(timestamp)
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