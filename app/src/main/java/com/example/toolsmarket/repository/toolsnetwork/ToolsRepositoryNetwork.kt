package com.example.toolsmarket.repository.toolsnetwork

import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.networks.ToolsApi
import retrofit2.Response
import javax.inject.Inject

class ToolsRepositoryNetwork @Inject constructor(private val toolsApi: ToolsApi) :
    IToolsRepositoryNetwork {
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