package com.angelmc.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.net.NetworkInterface
import java.util.regex.Pattern

import com.angelmc.R
import com.angelmc.adapters.ServerListAdapter


class FindServerActivity : AppCompatActivity() {

    private lateinit var serverList: RecyclerView
    private lateinit var updateServerList: FloatingActionButton
    private lateinit var serverListAdapter: ServerListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_server)

        updateServerList = findViewById(R.id.update_server_list)
        serverList = findViewById(R.id.servers_list)

        val serverListData = ArrayList<String>()
        serverListAdapter = ServerListAdapter(serverListData)

        serverList.adapter = serverListAdapter
        serverList.layoutManager = LinearLayoutManager(this)

        updateIpAddresses()
    }

    private fun updateIpAddresses() {
        val interfaces = NetworkInterface.getNetworkInterfaces()
        val serverListData = ArrayList<String>()
        for (inter in interfaces) {
            val address = inter.inetAddresses
            for (addr in address) {
                val hostAddress = addr.hostAddress
                if(!isLocalHost(hostAddress) && validate(hostAddress)) {
                    serverListData.add(hostAddress)
                }
            }
        }
        serverListAdapter.servers = serverListData
    }

    private val PATTERN = Pattern.compile(
        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"
    )

    private fun validate(ip: String): Boolean {
        return PATTERN.matcher(ip).matches()
    }

    private fun isLocalHost(ipAddress: String): Boolean {
        return ipAddress != "127.0.0.1"
    }
}
