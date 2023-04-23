package com.example.toolsmarket.networks

import com.example.toolsmarket.adapters.ToolListAdapter

interface INetworkSource {
    suspend fun sendSubmitList(adapter: ToolListAdapter)
}