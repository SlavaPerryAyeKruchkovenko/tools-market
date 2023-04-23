package com.example.toolsmarket.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toolsmarket.models.Tool
import com.example.toolsmarket.repository.ToolsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ToolsFragmentViewModel : ViewModel() {
    val liveData = MutableLiveData<List<Tool>>()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://develtop.ru/study/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val toolsApi = retrofit.create(ToolsApi::class.java)

    public fun init() {
        GlobalScope.launch {
            val response = toolsApi.getTools()

            if (response.isSuccessful) {
                val responses = response.body()
                val tools = responses?.let { Tool.getTools(it) }
                liveData.postValue(tools)
            }
        }

    }
}