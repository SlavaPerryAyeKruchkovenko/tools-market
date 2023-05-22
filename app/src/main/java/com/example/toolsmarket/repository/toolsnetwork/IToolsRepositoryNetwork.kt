package com.example.toolsmarket.repository.toolsnetwork

import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface IToolsRepositoryNetwork {
    suspend fun getTools(): Response<List<ToolRequest>>
    suspend fun getBrokeTools(): Response<List<ToolRequest>>
    suspend fun getLegacyTools(): Response<List<ToolRequest>>
}