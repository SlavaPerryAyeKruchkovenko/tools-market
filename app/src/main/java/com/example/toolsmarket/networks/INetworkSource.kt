package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.adapters.ToolListAdapter
import com.example.toolsmarket.models.Tool

interface INetworkSource {
    fun sendData(liveData: MutableLiveData<List<Tool>>)
}