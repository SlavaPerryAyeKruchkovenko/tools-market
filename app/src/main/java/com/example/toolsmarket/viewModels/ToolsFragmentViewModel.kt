package com.example.toolsmarket.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ApiNetworkSource
import com.example.toolsmarket.networks.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import com.example.toolsmarket.models.ResultOf
import kotlinx.coroutines.launch

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<ResultOf<List<Tool>?>>()
    private val network: INetworkSource = ApiNetworkSource()
    fun init() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                network.getTools()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                val result = ResultOf.Success(tools)
                liveData.postValue(result)
            } else {
                liveData.postValue(ResultOf.Failure("internet error", "check your internet connection"))
            }
        }
    }
}