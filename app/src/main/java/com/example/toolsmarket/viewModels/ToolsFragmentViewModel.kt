package com.example.toolsmarket.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ApiNetworkSource
import com.example.toolsmarket.networks.INetworkSource
import com.example.toolsmarket.networks.MockNetworkSource
import com.example.toolsmarket.repository.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    private val network: INetworkSource = ApiNetworkSource()
    fun init() {
        network.sendData(liveData)
        viewModelScope.launch{
            val response = withContext(Dispatchers.IO) {
                RetrofitBuilder.toolsApi.getTools()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                liveData.postValue(tools)
            }
        }
    }
}