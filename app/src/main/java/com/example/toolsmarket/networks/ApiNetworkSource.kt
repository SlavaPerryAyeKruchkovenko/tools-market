package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.models.ToolRequest
import com.example.toolsmarket.repository.RetrofitBuilder
import kotlinx.coroutines.*
import retrofit2.Response

class ApiNetworkSource: INetworkSource {

    override suspend fun sendData(): Response<List<ToolRequest>> {
        return RetrofitBuilder.toolsApi.getTools()
    }
}