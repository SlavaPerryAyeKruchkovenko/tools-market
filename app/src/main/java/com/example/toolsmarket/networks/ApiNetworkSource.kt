package com.example.toolsmarket.networks

import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.repository.RetrofitBuilder
import retrofit2.Response

class ApiNetworkSource: INetworkSource {

    override suspend fun getTools(): Response<List<ToolRequest>> {
        return RetrofitBuilder.toolsApi.getTools()
    }
}