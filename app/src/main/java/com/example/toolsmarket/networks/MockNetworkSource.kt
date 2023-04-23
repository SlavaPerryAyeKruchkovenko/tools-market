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
            Tool.DefaultTool("header","gay","https://s.mediasalt.ru/images/309/309640/original.jpg"),
            Tool.RoundTool("Hello i am putin and i wanna fuck you","Hello","https://s.mediasalt.ru/images/309/309640/original.jpg",true)
        )
    }
}