package com.example.toolsmarket.repository

import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response

interface IToolsRepository {
    suspend fun getTools(): Response<List<ToolRequest>>
    suspend fun getBrokeTools(): Response<List<ToolRequest>>
    suspend fun getLegacyTools(): Response<List<ToolRequest>>
}