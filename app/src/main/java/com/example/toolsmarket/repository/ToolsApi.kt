package com.example.toolsmarket.repository

import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response
import retrofit2.http.GET

interface ToolsApi {
    @GET("new.json")
    suspend fun getTools(): Response<List<ToolRequest>>
}