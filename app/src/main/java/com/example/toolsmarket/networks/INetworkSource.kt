package com.example.toolsmarket.networks

import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface INetworkSource {
    suspend fun getTools(): Response<List<ToolRequest>>
}