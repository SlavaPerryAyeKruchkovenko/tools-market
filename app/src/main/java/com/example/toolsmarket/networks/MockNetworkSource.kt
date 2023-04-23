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
    private fun getTools():List<Tool>{
        return listOf(
            Tool.ToolWithoutImage("header","gay"),
            Tool.DefaultTool("header","gay","https://drive.google.com/file/u/1/d/1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX/view?usp=drive_open"),
            Tool.RoundTool("Hello","Hello","https://drive.google.com/file/u/1/d/1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX/view?usp=drive_open",true)
        )
    }
}