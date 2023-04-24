package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repository.ToolsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MockNetworkSource: INetworkSource {
    override fun sendData(liveData: MutableLiveData<List<Tool>>) {
        val tools = getTools()
        liveData.postValue(tools)
    }
    public fun getTools():List<Tool>{
        return listOf(
            Tool.ToolWithoutImage("header","gay"),
            Tool.DefaultTool("header","gay","https://img5.goodfon.ru/original/2048x2048/b/3b/devushka-kosichki-tv-series-netflix-teleserial-2022-wednesda.jpg"),
            Tool.RoundTool("Hello i am putin and i wanna fuck you","Hello","https://s.mediasalt.ru/images/309/309640/original.jpg",true)
        )
    }
}