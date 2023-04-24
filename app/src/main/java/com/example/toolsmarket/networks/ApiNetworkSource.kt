package com.example.toolsmarket.networks

import androidx.lifecycle.MutableLiveData
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repository.RetrofitBuilder
import kotlinx.coroutines.*

class ApiNetworkSource: INetworkSource {

    override fun sendData(liveData: MutableLiveData<List<Tool>>) {

    }
}