package com.example.toolsmarket.viewModels

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.*
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.networks.ApiNetworkSource
import com.example.toolsmarket.networks.INetworkSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.toolsmarket.ToolsApp
import com.example.toolsmarket.models.ResultOf
import com.example.toolsmarket.repository.ToolsApi
import dagger.MapKey
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ToolsFragmentViewModel @Inject constructor(private val toolsApi: ToolsApi) : ViewModel() {
    val liveData = MutableLiveData<ResultOf<List<Tool>?>>()

    fun init() {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                toolsApi.getTools()
            }
            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                val result = ResultOf.Success(tools)
                liveData.postValue(result)
            } else {
                liveData.postValue(
                    ResultOf.Failure(
                        "internet error",
                        "check your internet connection"
                    )
                )
            }
        }
    }
}
