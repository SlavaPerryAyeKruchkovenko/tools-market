package com.example.toolsmarket.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ApiNetworkSource
import com.example.toolsmarket.networks.INetworkSource
import com.example.toolsmarket.networks.MockNetworkSource

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    private val network: INetworkSource = MockNetworkSource()
    fun init() {
        network.sendData(liveData)
    }
}