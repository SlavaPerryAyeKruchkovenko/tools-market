package com.example.toolsmarket.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.INetworkSource
import com.example.toolsmarket.networks.MockNetworkSource
import com.example.toolsmarket.repository.ToolsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    private val network: INetworkSource = MockNetworkSource()
    public fun init() {
        network.sendData(liveData);
    }
}