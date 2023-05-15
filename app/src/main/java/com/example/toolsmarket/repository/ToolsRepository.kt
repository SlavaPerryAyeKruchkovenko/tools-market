package com.example.toolsmarket.repository

import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.networks.ToolsApi
import retrofit2.Response
import javax.inject.Inject

class ToolsRepository @Inject constructor(private val toolsApi: ToolsApi) : IToolsRepository {
    public override suspend fun getTools(): Response<List<ToolRequest>> {
        return toolsApi.getTools()
    }
    public override suspend fun getLegacyTools(): Response<List<ToolRequest>> {
        return toolsApi.getLegacyTools()
    }
    public override suspend fun getBrokeTools(): Response<List<ToolRequest>> {
        return toolsApi.getBrokeTools()
    }
}