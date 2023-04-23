package com.example.toolsmarket.networks

import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.repository.ToolsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MockNetworkSource: INetworkSource {
    override suspend fun sendSubmitList(adapter: ToolListAdapter) {


    }
}