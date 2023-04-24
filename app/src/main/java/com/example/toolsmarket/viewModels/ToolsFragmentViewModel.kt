package com.example.toolsmarket.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ApiNetworkSource
import com.example.toolsmarket.networks.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    private val network: INetworkSource = ApiNetworkSource()
    fun init() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                network.sendData()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                liveData.postValue(tools)
            }
        }
    }
}