package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repository.ToolsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiNetworkSource: INetworkSource {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://develtop.ru/study/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val toolsApi = retrofit.create(ToolsApi::class.java)
    override fun sendData(liveData: MutableLiveData<List<Tool>>) {
        GlobalScope.launch {
            val response = toolsApi.getTools()

            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                liveData.postValue(tools)
            }
        }
    }
}