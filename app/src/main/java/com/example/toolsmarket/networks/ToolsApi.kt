package com.example.toolsmarket.networks

import com.example.toolsmarket.models.ToolRequest
import retrofit2.Response
import retrofit2.http.GET

interface ToolsApi {
    @GET("new.json")
    suspend fun getLegacyTools(): Response<List<ToolRequest>>
    @GET("text.json")
    suspend fun getBrokeTools(): Response<List<ToolRequest>>
    @GET("new_text.json")
    suspend fun getTools(): Response<List<ToolRequest>>
}