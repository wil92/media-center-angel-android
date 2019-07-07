package com.angelmc.views

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angelmc.R

class ServerItemViewHolder(item: View): RecyclerView.ViewHolder(item) {
    fun serverName(serverName: String) {
        val serverNameView = itemView.findViewById<TextView>(R.id.server_name)
        serverNameView.text = serverName
    }
}
