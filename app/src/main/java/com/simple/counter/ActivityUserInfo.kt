package com.simple.counter

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import org.w3c.dom.Text

class ActivityUserInfo : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        var chatName: String? = intent.getStringExtra("CHAT_NAME")
        var profilePictureUrl: String? = intent.getStringExtra("PROFILE_PIC")
        var chatMessage: String? = intent.getStringExtra("MESSAGE")

        var profilePicture: RoundedImageView = findViewById(R.id.profilePicture)
        var textViewChatName: TextView = findViewById(R.id.chatName)
        var textViewChatMessage : TextView = findViewById(R.id.chatMessage)
        var background: ImageView = findViewById(R.id.background)

        Glide.with(this).load(profilePictureUrl).into(profilePicture)
        Glide.with(this).load("https://theabbie.github.io/blog/assets/official-whatsapp-background-image.jpg").into(background)
        textViewChatName.text = chatName
        textViewChatMessage.text = chatMessage



    }

}