package com.angelmc.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelmc.R

import com.angelmc.views.ServerItemViewHolder

class ServerListAdapter(var servers: ArrayList<String>): RecyclerView.Adapter<ServerItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServerItemViewHolder {
        val itemView = View.inflate(parent.context, R.layout.item_server, null)
        return ServerItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return servers.size
    }

    override fun onBindViewHolder(holder: ServerItemViewHolder, position: Int) {
        holder.serverName(servers[position])
    }
}