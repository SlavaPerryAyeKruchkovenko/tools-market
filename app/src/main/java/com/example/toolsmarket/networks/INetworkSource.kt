package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface INetworkSource {
    suspend fun sendData(): Response<List<ToolRequest>>
}